package dev.micheleferretti.mapboxpluginoffline

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions
import dev.micheleferretti.mapboxpluginoffline.utils.requireLong

/**
 * This `BroadcastReceiver` can be used to intercept [OfflineService][dev.micheleferretti.mapboxpluginoffline.OfflineService]
 * events and monitor active downloads.
 */
open class OfflineDownloadReceiver: BroadcastReceiver() {

    internal companion object {
        const val ACTION_CREATE = "action.CREATE"
        const val ACTION_CREATE_ERROR = "action.CREATE_ERROR"
        const val ACTION_DELETE = "action.DELETE"
        const val ACTION_DELETE_ERROR = "action.DELETE_ERROR"
        const val ACTION_STATUS_CHANGED = "action.STATUS_CHANGED"
        const val ACTION_OBSERVER_ERROR = "action.OBSERVER_ERROR"
        const val ACTION_TILE_COUNT_LIMIT_EXCEEDED = "action.TILE_COUNT_LIMIT_EXCEEDED"

        private const val EXTRA_1 = "extra.1"
        private const val EXTRA_2 = "extra.2"

        @JvmStatic
        fun dispatchCreate(context: Context, download: OfflineDownload) {
            dispatch(context, ACTION_CREATE, download.toBundle())
        }

        @JvmStatic
        fun dispatchCreateError(context: Context, options: OfflineDownloadOptions, error: String?) {
            dispatch(context, ACTION_CREATE_ERROR, options.toBundle().apply {
                putString(EXTRA_1, error)
            })
        }

        @JvmStatic
        fun dispatchDelete(context: Context, download: OfflineDownload) {
            dispatch(context, ACTION_DELETE, download.toBundle())
        }

        @JvmStatic
        fun dispatchDeleteError(context: Context, download: OfflineDownload, error: String?) {
            dispatch(context, ACTION_DELETE_ERROR, download.toBundle().apply {
                putString(EXTRA_1, error)
            })
        }

        @JvmStatic
        fun dispatchStatusChanged(context: Context, download: OfflineDownload) {
            dispatch(context, ACTION_STATUS_CHANGED, download.toBundle())
        }

        @JvmStatic
        fun dispatchObserverError(context: Context, download: OfflineDownload, reason: String?, message: String?) {
            dispatch(context, ACTION_OBSERVER_ERROR, download.toBundle().apply {
                putString(EXTRA_1, reason)
                putString(EXTRA_2, message)
            })
        }

        @JvmStatic
        fun dispatchTileCountLimitExceeded(context: Context, download: OfflineDownload, limit: Long) {
            dispatch(context, ACTION_TILE_COUNT_LIMIT_EXCEEDED, download.toBundle().apply {
                putLong(EXTRA_1, limit)
            })
        }

        private fun dispatch(context: Context, intentAction: String, intentExtras: Bundle) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(Intent().apply {
                action = intentAction
                putExtras(intentExtras)
            })
        }
    }

    /**
     * Map of current active downloads. This map is cleared when [unregister] is called.
     */
    val activeDownloads = hashMapOf<Long, OfflineDownload>()

    /**
     * Registers this receiver to all the actions.
     * @param context Context used to get the `LocalBroadcastManager` instance.
     */
    fun register(context: Context) = LocalBroadcastManager.getInstance(context).registerReceiver(this, IntentFilter().apply {
        addAction(ACTION_CREATE)
        addAction(ACTION_CREATE_ERROR)
        addAction(ACTION_DELETE)
        addAction(ACTION_DELETE_ERROR)
        addAction(ACTION_STATUS_CHANGED)
        addAction(ACTION_OBSERVER_ERROR)
        addAction(ACTION_TILE_COUNT_LIMIT_EXCEEDED)
    })

    /**
     * Unregisters this receiver and clears the [activeDownloads] map.
     */
    fun unregister(context: Context) {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(this)
        activeDownloads.clear()
    }

    /**
     * @suppress This is used only as a dispatcher to the other callbacks: documentation not needed.
     */
    override fun onReceive(context: Context?, intent: Intent?) {
        val ctx = context?.applicationContext ?: return
        when (intent?.action) {
            ACTION_CREATE -> intent.extras?.also {
                onCreate(ctx, OfflineDownload.fromBundle(it))
            }
            ACTION_CREATE_ERROR -> intent.extras?.also {
                onCreateError(ctx, OfflineDownloadOptions.fromBundle(it), it.getString(EXTRA_1))
            }
            ACTION_DELETE -> intent.extras?.also {
                onDelete(ctx, OfflineDownload.fromBundle(it))
            }
            ACTION_DELETE_ERROR -> intent.extras?.also {
                onDeleteError(ctx, OfflineDownload.fromBundle(it), it.getString(EXTRA_1))
            }
            ACTION_STATUS_CHANGED -> intent.extras?.also {
                onStatusChanged(ctx, OfflineDownload.fromBundle(it))
            }
            ACTION_OBSERVER_ERROR -> intent.extras?.also {
                onObserverError(ctx, OfflineDownload.fromBundle(it), it.getString(EXTRA_1), it.getString(EXTRA_2))
            }
            ACTION_TILE_COUNT_LIMIT_EXCEEDED -> intent.extras?.also {
                onTileCountLimitExceeded(ctx, OfflineDownload.fromBundle(it), it.requireLong(EXTRA_1))
            }
        }
    }

    /**
     * Called when a download is created, see `OfflineManager.CreateOfflineRegionCallback.onCreate()`.
     * @param context Receiver Context.
     * @param download The created download.
     */
    @CallSuper
    open fun onCreate(context: Context, download: OfflineDownload) {
        activeDownloads[download.regionId] = download
    }

    /**
     * Called when a download creation fails, see `OfflineManager.CreateOfflineRegionCallback.onError()`.
     * @param context Receiver Context.
     * @param options The options used to create the download.
     * @param error Error message.
     */
    open fun onCreateError(context: Context, options: OfflineDownloadOptions, error: String?) {
        // no-op
    }

    /**
     * Called when a download is canceled and the region deleted, see `OfflineRegion.OfflineRegionDeleteCallback.onDelete()`.
     * @param context Receiver Context.
     * @param download The canceled and deleted download.
     */
    @CallSuper
    open fun onDelete(context: Context, download: OfflineDownload) {
        activeDownloads.remove(download.regionId)
    }

    /**
     * Called when a download is canceled but the region deletion fails, see `OfflineRegion.OfflineRegionDeleteCallback.onError()`.
     * @param context Receiver Context.
     * @param download The canceled but not deleted download.
     * @param error Error message.
     */
    @CallSuper
    open fun onDeleteError(context: Context, download: OfflineDownload, error: String?) {
        activeDownloads.remove(download.regionId)
    }

    /**
     * Called when a download changes its status, see `OfflineRegion.OfflineRegionObserver.onStatusChanged()`.
     * @param context Receiver Context.
     * @param download The observed download.
     */
    @CallSuper
    open fun onStatusChanged(context: Context, download: OfflineDownload) {
        if (download.isActive()) activeDownloads[download.regionId] = download else activeDownloads.remove(download.regionId)
    }

    /**
     * Called when a download observer fails, see `OfflineRegion.OfflineRegionObserver.onError()`.
     * @param context Receiver Context.
     * @param download The observed download.
     * @param reason Error reason (see `OfflineRegionError.getReason()`).
     * @param message Error message (see `OfflineRegionError.getMessage()`).
     */
    @CallSuper
    open fun onObserverError(context: Context, download: OfflineDownload, reason: String?, message: String?) {
        activeDownloads.remove(download.regionId)
    }

    /**
     * Called when a download tile count exceeds `limit`, see `OfflineRegion.OfflineRegionObserver.mapboxTileCountLimitExceeded()`.
     * @param context Receiver Context.
     * @param download The observed download.
     * @param limit Maximum tile count.
     */
    @CallSuper
    open fun onTileCountLimitExceeded(context: Context, download: OfflineDownload, limit: Long) {
        activeDownloads.remove(download.regionId)
    }
}