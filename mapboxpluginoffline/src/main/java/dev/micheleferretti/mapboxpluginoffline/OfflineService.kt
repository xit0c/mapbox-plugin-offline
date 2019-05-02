package dev.micheleferretti.mapboxpluginoffline

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import androidx.core.app.NotificationManagerCompat
import com.mapbox.mapboxsdk.offline.OfflineManager
import com.mapbox.mapboxsdk.offline.OfflineRegion
import com.mapbox.mapboxsdk.offline.OfflineRegionError
import com.mapbox.mapboxsdk.offline.OfflineRegionStatus
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadJob
import dev.micheleferretti.mapboxpluginoffline.utils.NotificationUtils
import dev.micheleferretti.mapboxpluginoffline.utils.requireLong

class OfflineService : Service() {

    companion object {
        const val ACTION_DOWNLOAD = "action.DOWNLOAD"
        const val ACTION_CANCEL = "action.CANCEL"

        private const val EXTRA_REGION_ID = "extra.REGION_ID"

        @JvmStatic
        fun startDownload(context: Context, offlineDownloadOptions: OfflineDownloadOptions) {
            context.startService(createIntent(context, ACTION_DOWNLOAD, offlineDownloadOptions.toBundle()))
        }

        @JvmStatic
        fun cancelDownload(context: Context, regionId: Long) {
            context.startService(createIntent(context, ACTION_CANCEL, regionId))
        }

        @JvmStatic
        fun createIntent(context: Context, intentAction: String, regionId: Long) =
            createIntent(context, intentAction, Bundle().apply { putLong(EXTRA_REGION_ID, regionId) })

        @JvmStatic
        fun createIntent(context: Context, intentAction: String, intentExtras: Bundle) =
            Intent(context, OfflineService::class.java).apply {
                action = intentAction
                putExtras(intentExtras)
            }
    }

    private lateinit var notificationManager: NotificationManagerCompat

    private val jobs = hashMapOf<Long, OfflineDownloadJob>()

    override fun onCreate() {
        super.onCreate()
        notificationManager = NotificationManagerCompat.from(applicationContext)
        NotificationUtils.setupNotificationChannel(applicationContext)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_DOWNLOAD -> {
                val options = OfflineDownloadOptions.fromBundle(requireNotNull(intent.extras))
                OfflineManager.getInstance(applicationContext).createOfflineRegion(
                    options.definition,
                    options.metadata ?: byteArrayOf(),
                    object : OfflineManager.CreateOfflineRegionCallback {
                        override fun onCreate(offlineRegion: OfflineRegion?) {
                            if (offlineRegion != null) startJob(OfflineDownloadJob(applicationContext, options, offlineRegion))
                            else OfflineDownloadReceiver.dispatchCreateError(applicationContext, options, "OfflineRegion is null")
                        }

                        override fun onError(error: String?) {
                            OfflineDownloadReceiver.dispatchCreateError(applicationContext, options, error)
                        }
                    }
                )
            }
            ACTION_CANCEL -> intent.extras?.requireLong(EXTRA_REGION_ID)?.also {
                val job = jobs[it]
                if (job != null) {
                    notificationManager.notify(job.region.id.toInt(), job.notificationCancel.build())
                    job.region.setDownloadState(OfflineRegion.STATE_INACTIVE)
                    job.region.setObserver(null)
                    job.region.delete(object : OfflineRegion.OfflineRegionDeleteCallback {
                        override fun onDelete() {
                            OfflineDownloadReceiver.dispatchDelete(applicationContext, job.download)
                            finishJob(it)
                        }

                        override fun onError(error: String?) {
                            OfflineDownloadReceiver.dispatchDeleteError(applicationContext, job.download, error)
                            finishJob(it)
                        }
                    })
                }
            }
        }

        return START_STICKY
    }

    private fun startJob(job: OfflineDownloadJob) {
        jobs[job.region.id] = job

        OfflineDownloadReceiver.dispatchCreate(applicationContext, job.download)

        // Setup observer
        job.region.setObserver(object : OfflineRegion.OfflineRegionObserver {
            override fun onStatusChanged(status: OfflineRegionStatus?) {
                when {
                    status == null -> return
                    status.isComplete -> {
                        job.region.setDownloadState(OfflineRegion.STATE_INACTIVE)
                        job.region.setObserver(null)
                        job.updateDownload(status)
                        OfflineDownloadReceiver.dispatchStatusChanged(applicationContext, job.download)
                        finishJob(job.region.id)
                    }
                    else -> {
                        val oldPercentage = job.download.getPercentage()
                        val newPercentage = OfflineDownload.getPercentage(status.completedResourceCount, status.requiredResourceCount)
                        if (newPercentage >= (oldPercentage + 2)) {
                            job.updateDownload(status)
                            notificationManager.notify(job.region.id.toInt(), job.getNotificationDownload())
                            OfflineDownloadReceiver.dispatchStatusChanged(applicationContext, job.download)
                        }
                    }
                }
            }

            override fun onError(error: OfflineRegionError?) {
                OfflineDownloadReceiver.dispatchObserverError(applicationContext, job.download, error?.reason, error?.message)
                finishJob(job.region.id)
            }

            override fun mapboxTileCountLimitExceeded(limit: Long) {
                OfflineDownloadReceiver.dispatchTileCountLimitExceeded(applicationContext, job.download, limit)
                finishJob(job.region.id)
            }
        })

        // Start download
        job.region.setDownloadState(OfflineRegion.STATE_ACTIVE)

        // Start foreground service
        startForeground(job.region.id.toInt(), job.getNotificationDownload())
    }

    private fun finishJob(id: Long) {
        val job = jobs.remove(id)
        if (job != null) {
            notificationManager.cancel(id.toInt())
            job.snapshotter?.cancel()
        }
        if (jobs.isEmpty()) {
            stopForeground(false)
            stopSelf()
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
