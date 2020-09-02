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
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadJob
import dev.micheleferretti.mapboxpluginoffline.utils.NotificationUtils
import dev.micheleferretti.mapboxpluginoffline.utils.getCompletionPercentage
import dev.micheleferretti.mapboxpluginoffline.utils.requireLong

/**
 * This is the core of the plugin. It manages the downloads, shows notifications and dispatches events that
 * [OfflineDownloadReceiver]s can listen to.
 *
 * The static methods [startDownload] and [cancelDownload], as their names suggest, can be used to
 * start and cancel a download respectively. While executing these actions, the service shows a notification
 * to make the user aware of what's going on.
 */
class OfflineService : Service() {

    companion object {
        private const val CONSTANT_PREFIX   = "dev.micheleferretti.mapboxpluginoffline.OfflineService"

        internal const val ACTION_DOWNLOAD  = "$CONSTANT_PREFIX.action.DOWNLOAD"
        internal const val ACTION_CANCEL    = "$CONSTANT_PREFIX.action.CANCEL"

        private const val EXTRA_OPTIONS     = "$CONSTANT_PREFIX.extra.OPTIONS"
        private const val EXTRA_REGION_ID   = "$CONSTANT_PREFIX.extra.REGION_ID"

        /**
         * Starts a new download with the provided options.
         * @param context Context used to start the service.
         * @param offlineDownloadOptions Download options.
         */
        @JvmStatic
        fun startDownload(context: Context, offlineDownloadOptions: OfflineDownloadOptions) {
            context.startService(createIntent(context, ACTION_DOWNLOAD) {
                putParcelable(EXTRA_OPTIONS, offlineDownloadOptions)
            })
        }

        /**
         * Cancels an active download and deletes its region.
         * @param context Context used to start the service.
         * @param regionId The download region id.
         */
        @JvmStatic
        fun cancelDownload(context: Context, regionId: Long) {
            context.startService(createIntent(context, ACTION_CANCEL, regionId))
        }

        @JvmStatic
        internal fun createIntent(context: Context, intentAction: String, regionId: Long) =
            createIntent(context, intentAction) { putLong(EXTRA_REGION_ID, regionId) }

        @JvmStatic
        internal fun createIntent(context: Context, intentAction: String, extrasBlock: Bundle.() -> Unit) =
            Intent(intentAction, null, context, OfflineService::class.java).putExtras(Bundle().apply(extrasBlock))
    }

    private lateinit var notificationManager: NotificationManagerCompat

    private val jobs = hashMapOf<Long, OfflineDownloadJob>()

    /**
     * @suppress documentation not needed.
     */
    override fun onBind(intent: Intent?): IBinder? = null

    /**
     * @suppress documentation not needed.
     */
    override fun onCreate() {
        super.onCreate()
        notificationManager = NotificationManagerCompat.from(applicationContext)
        NotificationUtils.setupNotificationChannel(applicationContext)
    }

    /**
     * @suppress documentation not needed.
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_DOWNLOAD -> {
                val options = requireNotNull(intent.extras?.getParcelable<OfflineDownloadOptions>(EXTRA_OPTIONS))
                OfflineManager.getInstance(applicationContext).createOfflineRegion(
                    options.definition,
                    options.metadata ?: byteArrayOf(),
                    object : OfflineManager.CreateOfflineRegionCallback {
                        override fun onCreate(offlineRegion: OfflineRegion?) {
                            if (offlineRegion == null) onError("offlineRegion is null")
                            else startJob(OfflineDownloadJob(applicationContext, options, offlineRegion))
                        }

                        override fun onError(error: String?) {
                            OfflineDownloadReceiver.dispatchCreateError(applicationContext, options, error)
                        }
                    }
                )
            }
            ACTION_CANCEL -> {
                val regionId = requireNotNull(intent.extras).requireLong(EXTRA_REGION_ID)
                val job = jobs[regionId]
                if (job != null) {
                    notificationManager.notify(job.region.id.toInt(), job.getNotificationCancel())
                    job.region.setDownloadState(OfflineRegion.STATE_INACTIVE)
                    job.region.setObserver(null)
                    job.region.delete(object : OfflineRegion.OfflineRegionDeleteCallback {
                        override fun onDelete() {
                            OfflineDownloadReceiver.dispatchDelete(applicationContext, job.download)
                            finishJob(regionId)
                        }

                        override fun onError(error: String?) {
                            OfflineDownloadReceiver.dispatchDeleteError(applicationContext, job.download, error)
                            finishJob(regionId)
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
                        job.download.setStatus(status)
                        OfflineDownloadReceiver.dispatchStatusChanged(applicationContext, job.download)
                        finishJob(job.region.id)
                    }
                    else -> {
                        val oldPercentage = job.download.getPercentage()
                        val newPercentage = status.getCompletionPercentage()
                        if (newPercentage >= (oldPercentage + 2)) {
                            job.download.setStatus(status)
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

    @Synchronized
    private fun finishJob(regionId: Long) {
        val job = jobs.remove(regionId)
        if (job != null) {
            notificationManager.cancel(regionId.toInt())
            job.cancelSnapshotter()
        }
        if (jobs.isEmpty()) {
            stopForeground(false)
            stopSelf()
        }
    }
}
