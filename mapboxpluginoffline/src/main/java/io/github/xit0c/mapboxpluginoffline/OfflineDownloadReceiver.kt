package io.github.xit0c.mapboxpluginoffline

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.CallSuper
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import io.github.xit0c.mapboxpluginoffline.model.OfflineDownload
import io.github.xit0c.mapboxpluginoffline.model.OfflineDownloadOptions
import io.github.xit0c.mapboxpluginoffline.utils.requireLong

/**
 * This `BroadcastReceiver` can be used to intercept [OfflineService] events and monitor active downloads.
 */
open class OfflineDownloadReceiver: BroadcastReceiver() {

    internal companion object {
        private const val CONSTANT_PREFIX                   = "io.github.xit0c.mapboxpluginoffline.OfflineDownloadReceiver"

        private const val ACTION_CREATE                     = "$CONSTANT_PREFIX.action.CREATE"
        private const val ACTION_CREATE_ERROR               = "$CONSTANT_PREFIX.action.CREATE_ERROR"
        private const val ACTION_DELETE                     = "$CONSTANT_PREFIX.action.DELETE"
        private const val ACTION_DELETE_ERROR               = "$CONSTANT_PREFIX.action.DELETE_ERROR"
        private const val ACTION_STATUS_CHANGED             = "$CONSTANT_PREFIX.action.STATUS_CHANGED"
        private const val ACTION_OBSERVER_ERROR             = "$CONSTANT_PREFIX.action.OBSERVER_ERROR"
        private const val ACTION_TILE_COUNT_LIMIT_EXCEEDED  = "$CONSTANT_PREFIX.action.TILE_COUNT_LIMIT_EXCEEDED"

        private const val EXTRA_PARCELABLE                  = "$CONSTANT_PREFIX.extra.PARCELABLE"
        private const val EXTRA_1                           = "$CONSTANT_PREFIX.extra.1"
        private const val EXTRA_2                           = "$CONSTANT_PREFIX.extra.2"

        @JvmStatic
        fun dispatchCreate(context: Context, download: OfflineDownload) {
            dispatch(context, ACTION_CREATE, download)
        }

        @JvmStatic
        fun dispatchCreateError(context: Context, options: OfflineDownloadOptions, error: String?) {
            dispatch(context, ACTION_CREATE_ERROR, options) { putString(EXTRA_1, error) }
        }

        @JvmStatic
        fun dispatchDelete(context: Context, download: OfflineDownload) {
            dispatch(context, ACTION_DELETE, download)
        }

        @JvmStatic
        fun dispatchDeleteError(context: Context, download: OfflineDownload, error: String?) {
            dispatch(context, ACTION_DELETE_ERROR, download) { putString(EXTRA_1, error) }
        }

        @JvmStatic
        fun dispatchStatusChanged(context: Context, download: OfflineDownload) {
            dispatch(context, ACTION_STATUS_CHANGED, download)
        }

        @JvmStatic
        fun dispatchObserverError(context: Context, download: OfflineDownload, reason: String?, message: String?) {
            dispatch(context, ACTION_OBSERVER_ERROR, download) {
                putString(EXTRA_1, reason)
                putString(EXTRA_2, message)
            }
        }

        @JvmStatic
        fun dispatchTileCountLimitExceeded(context: Context, download: OfflineDownload, limit: Long) {
            dispatch(context, ACTION_TILE_COUNT_LIMIT_EXCEEDED, download) { putLong(EXTRA_1, limit) }
        }

        private fun dispatch(context: Context, intentAction: String, parcelable: Parcelable, extrasBlock: (Bundle.() -> Unit)? = null) {
            LocalBroadcastManager.getInstance(context).sendBroadcast(Intent().apply {
                action = intentAction
                putExtra(EXTRA_PARCELABLE, parcelable)
                if (extrasBlock != null) putExtras(Bundle().apply(extrasBlock))
            })
        }
    }

    /**
     * List of current active downloads, cleared when [unregister] is called.
     */
    private val activeDownloads = mutableListOf<OfflineDownload>()

    /**
     * Insert or upload `download` in `activeDownloads` list.
     * @param context Receiver Context.
     * @param download The active download.
     */
    private fun putActiveDownload(context: Context, download: OfflineDownload) {
        val index = activeDownloads.indexOfFirst { it.regionId == download.regionId }
        if (index != -1) activeDownloads[index] = download else activeDownloads.add(download)
        onActiveDownloadsChanged(context, activeDownloads)
    }

    /**
     * Remove `download` from `activeDownloads` list.
     * @param context Receiver Context.
     * @param download The inactive download.
     */
    private fun removeActiveDownload(context: Context, download: OfflineDownload) {
        val index = activeDownloads.indexOfFirst { it.regionId == download.regionId }
        if (index != -1) {
            activeDownloads.removeAt(index)
            onActiveDownloadsChanged(context, activeDownloads)
        }
    }

    /**
     * Returns a list of current active downloads.
     * @return a list of current active downloads.
     */
    fun getActiveDownloads(): List<OfflineDownload> = activeDownloads

    /**
     * Registers this receiver to all the actions.
     * @param context Context used to get the `LocalBroadcastManager` instance.
     */
    @CallSuper
    open fun register(context: Context) = LocalBroadcastManager.getInstance(context).registerReceiver(this, IntentFilter().apply {
        addAction(ACTION_CREATE)
        addAction(ACTION_CREATE_ERROR)
        addAction(ACTION_DELETE)
        addAction(ACTION_DELETE_ERROR)
        addAction(ACTION_STATUS_CHANGED)
        addAction(ACTION_OBSERVER_ERROR)
        addAction(ACTION_TILE_COUNT_LIMIT_EXCEEDED)
    })

    /**
     * Unregisters this receiver and clears the internal list returned by [getActiveDownloads].
     * @param context Context used to get the `LocalBroadcastManager` instance.
     */
    @CallSuper
    open fun unregister(context: Context) {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(this)
        activeDownloads.clear()
    }

    /**
     * @suppress This is used only as a dispatcher to the other callbacks: documentation not needed.
     */
    @CallSuper
    override fun onReceive(context: Context?, intent: Intent?) {
        val ctx = context?.applicationContext ?: return
        when (intent?.action) {
            ACTION_CREATE -> intent.extras?.also {
                onCreate(ctx, requireNotNull(it.getParcelable(EXTRA_PARCELABLE)))
            }
            ACTION_CREATE_ERROR -> intent.extras?.also {
                onCreateError(ctx, requireNotNull(it.getParcelable(EXTRA_PARCELABLE)), it.getString(EXTRA_1))
            }
            ACTION_DELETE -> intent.extras?.also {
                onDelete(ctx, requireNotNull(it.getParcelable(EXTRA_PARCELABLE)))
            }
            ACTION_DELETE_ERROR -> intent.extras?.also {
                onDeleteError(ctx, requireNotNull(it.getParcelable(EXTRA_PARCELABLE)), it.getString(EXTRA_1))
            }
            ACTION_STATUS_CHANGED -> intent.extras?.also {
                onStatusChanged(ctx, requireNotNull(it.getParcelable(EXTRA_PARCELABLE)))
            }
            ACTION_OBSERVER_ERROR -> intent.extras?.also {
                onObserverError(ctx, requireNotNull(it.getParcelable(EXTRA_PARCELABLE)), it.getString(EXTRA_1), it.getString(EXTRA_2))
            }
            ACTION_TILE_COUNT_LIMIT_EXCEEDED -> intent.extras?.also {
                onTileCountLimitExceeded(ctx, requireNotNull(it.getParcelable(EXTRA_PARCELABLE)), it.requireLong(EXTRA_1))
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
        putActiveDownload(context, download)
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
        removeActiveDownload(context, download)
    }

    /**
     * Called when a download is canceled but the region deletion fails, see `OfflineRegion.OfflineRegionDeleteCallback.onError()`.
     * @param context Receiver Context.
     * @param download The canceled but not deleted download.
     * @param error Error message.
     */
    @CallSuper
    open fun onDeleteError(context: Context, download: OfflineDownload, error: String?) {
        removeActiveDownload(context, download)
    }

    /**
     * Called when a download changes its status, see `OfflineRegion.OfflineRegionObserver.onStatusChanged()`.
     * @param context Receiver Context.
     * @param download The observed download.
     */
    @CallSuper
    open fun onStatusChanged(context: Context, download: OfflineDownload) {
        if (download.isActive()) putActiveDownload(context, download) else removeActiveDownload(context, download)
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
        removeActiveDownload(context, download)
    }

    /**
     * Called when a download tile count exceeds `limit`, see `OfflineRegion.OfflineRegionObserver.mapboxTileCountLimitExceeded()`.
     * @param context Receiver Context.
     * @param download The observed download.
     * @param limit Maximum tile count.
     */
    @CallSuper
    open fun onTileCountLimitExceeded(context: Context, download: OfflineDownload, limit: Long) {
        removeActiveDownload(context, download)
    }

    /**
     * Called when `activeDownloads` list changes. Override this to respond to generic changes.
     * @param context Receiver Context.
     * @param activeDownloads The active downloads list.
     * @see getActiveDownloads
     */
    open fun onActiveDownloadsChanged(context: Context, activeDownloads: List<OfflineDownload>) {
        // no-op
    }
}