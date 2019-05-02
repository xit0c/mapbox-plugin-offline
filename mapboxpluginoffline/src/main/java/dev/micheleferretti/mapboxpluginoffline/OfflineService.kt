package dev.micheleferretti.mapboxpluginoffline

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationManagerCompat
import com.mapbox.mapboxsdk.offline.OfflineManager
import com.mapbox.mapboxsdk.offline.OfflineRegion
import com.mapbox.mapboxsdk.offline.OfflineRegionError
import com.mapbox.mapboxsdk.offline.OfflineRegionStatus
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions
import dev.micheleferretti.mapboxpluginoffline.model.OfflineWork
import dev.micheleferretti.mapboxpluginoffline.utils.NotificationUtils
import dev.micheleferretti.mapboxpluginoffline.utils.requireLong

class OfflineService : Service() {

    companion object {
        const val ACTION_DOWNLOAD = "action.DOWNLOAD"
        const val ACTION_CANCEL = "action.CANCEL"
        const val ACTION_PAUSE = "action.PAUSE"
        const val ACTION_RESUME = "action.RESUME"

        private const val EXTRA_REGION_ID = "extra.REGION_ID"
        private const val TAG = "OfflineService"

        @JvmStatic
        fun startDownload(context: Context, offlineDownloadOptions: OfflineDownloadOptions) {
            context.startService(createIntent(context, ACTION_DOWNLOAD, offlineDownloadOptions.toBundle()))
        }

        @JvmStatic
        fun cancelDownload(context: Context, regionId: Long) {
            context.startService(createIntent(context, ACTION_CANCEL, regionId))
        }

        @JvmStatic
        fun pauseDownload(context: Context, regionId: Long) {
            context.startService(createIntent(context, ACTION_PAUSE, regionId))
        }

        @JvmStatic
        fun resumeDownload(context: Context, regionId: Long) {
            context.startService(createIntent(context, ACTION_RESUME, regionId))
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

    private val works = hashMapOf<Long, OfflineWork>()

    override fun onCreate() {
        super.onCreate()
        notificationManager = NotificationManagerCompat.from(applicationContext)
        NotificationUtils.setupNotificationChannel(applicationContext)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: works = $works")
        when (intent?.action) {
            ACTION_DOWNLOAD -> {
                val options = OfflineDownloadOptions.fromBundle(requireNotNull(intent.extras))
                Log.d(TAG, "ACTION_DOWNLOAD: options = $options")
                OfflineManager.getInstance(applicationContext).createOfflineRegion(
                    options.definition,
                    options.metadata ?: byteArrayOf(),
                    object : OfflineManager.CreateOfflineRegionCallback {
                        override fun onCreate(offlineRegion: OfflineRegion?) {
                            if (offlineRegion != null) startWork(OfflineWork(applicationContext, options, offlineRegion))
                            else OfflineDownloadReceiver.dispatchCreateError(applicationContext, options, "OfflineRegion is null")
                        }

                        override fun onError(error: String?) {
                            OfflineDownloadReceiver.dispatchCreateError(applicationContext, options, error)
                        }
                    }
                )
            }
            ACTION_CANCEL -> intent.extras?.requireLong(EXTRA_REGION_ID)?.also {
                Log.d(TAG, "ACTION_CANCEL: regionId = $it")
                val work = works[it]
                if (work != null) {
                    notificationManager.notify(work.region.id.toInt(), work.notificationCancel.build())
                    work.region.setObserver(null)
                    work.region.setDownloadState(OfflineRegion.STATE_INACTIVE)
                    work.region.delete(object : OfflineRegion.OfflineRegionDeleteCallback {
                        override fun onDelete() {
                            OfflineDownloadReceiver.dispatchDelete(applicationContext, work.download)
                            finishWork(it)
                        }

                        override fun onError(error: String?) {
                            OfflineDownloadReceiver.dispatchDeleteError(applicationContext, work.download, error)
                            finishWork(it)
                        }
                    })
                }
            }
            ACTION_PAUSE -> intent.extras?.requireLong(EXTRA_REGION_ID)?.also {
                Log.d(TAG, "ACTION_PAUSE: regionId = $it")
                works[it]?.region?.setDownloadState(OfflineRegion.STATE_INACTIVE)
            }
            ACTION_RESUME -> intent.extras?.requireLong(EXTRA_REGION_ID)?.also {
                Log.d(TAG, "ACTION_RESUME: regionId = $it")
                works[it]?.region?.setDownloadState(OfflineRegion.STATE_ACTIVE)
            }
        }

        return START_STICKY
    }

    private fun startWork(work: OfflineWork) {
        works[work.region.id] = work

        OfflineDownloadReceiver.dispatchCreate(applicationContext, work.download)

        // Setup observer
        work.region.setDeliverInactiveMessages(true)
        work.region.setObserver(object : OfflineRegion.OfflineRegionObserver {
            override fun onStatusChanged(status: OfflineRegionStatus?) {
                when {
                    status == null -> return
                    status.isComplete -> {
                        Log.d(TAG, "onStatusChanged[isComplete]: regionId = ${work.region.id}")
                        work.region.setObserver(null)
                        work.region.setDownloadState(OfflineRegion.STATE_INACTIVE)
                        work.updateDownload(status)
                        OfflineDownloadReceiver.dispatchStatusChanged(applicationContext, work.download)
                        finishWork(work.region.id)
                    }
                    status.downloadState == OfflineRegion.STATE_INACTIVE -> {
                        Log.d(TAG, "onStatusChanged[isInactive]: regionId = ${work.region.id}")
                        if (works.containsKey(work.region.id)) {
                            work.updateDownload(status)
                            notificationManager.notify(work.region.id.toInt(), work.getNotificationPause())
                            OfflineDownloadReceiver.dispatchStatusChanged(applicationContext, work.download)
                        }
                    }
                    else -> {
                        Log.d(TAG, "onStatusChanged[isActive]: regionId = ${work.region.id}")
                        if (works.containsKey(work.region.id)) {
                            val oldPercentage = work.download.getPercentage()
                            val newPercentage = OfflineDownload.getPercentage(status.completedResourceCount, status.requiredResourceCount)
                            if (newPercentage >= (oldPercentage + 2)) {
                                work.updateDownload(status)
                                notificationManager.notify(work.region.id.toInt(), work.getNotificationResume())
                                OfflineDownloadReceiver.dispatchStatusChanged(applicationContext, work.download)
                            }
                        }
                    }
                }
            }

            override fun onError(error: OfflineRegionError?) {
                OfflineDownloadReceiver.dispatchObserverError(applicationContext, work.download, error?.reason, error?.message)
                finishWork(work.region.id)
            }

            override fun mapboxTileCountLimitExceeded(limit: Long) {
                OfflineDownloadReceiver.dispatchTileCountLimitExceeded(applicationContext, work.download, limit)
                finishWork(work.region.id)
            }
        })

        // Start download
        work.region.setDownloadState(OfflineRegion.STATE_ACTIVE)

        // Start foreground service
        startForeground(work.region.id.toInt(), work.getNotificationResume())
    }

    private fun finishWork(id: Long) {
        val removedWork = works.remove(id)
        if (removedWork != null) {
            notificationManager.cancel(id.toInt())
            removedWork.snapshotter?.cancel()
        }
        if (works.isEmpty()) {
            stopForeground(false)
            stopSelf()
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
