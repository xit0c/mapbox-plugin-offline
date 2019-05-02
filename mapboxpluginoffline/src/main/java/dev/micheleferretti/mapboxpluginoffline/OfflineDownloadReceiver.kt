package dev.micheleferretti.mapboxpluginoffline

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions
import dev.micheleferretti.mapboxpluginoffline.utils.requireLong

open class OfflineDownloadReceiver: BroadcastReceiver() {

    companion object {
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

    val currentDownloads = hashMapOf<Long, OfflineDownload>()

    fun register(context: Context) = LocalBroadcastManager.getInstance(context).registerReceiver(this, IntentFilter().apply {
        addAction(ACTION_CREATE)
        addAction(ACTION_CREATE_ERROR)
        addAction(ACTION_DELETE)
        addAction(ACTION_DELETE_ERROR)
        addAction(ACTION_STATUS_CHANGED)
        addAction(ACTION_OBSERVER_ERROR)
        addAction(ACTION_TILE_COUNT_LIMIT_EXCEEDED)
    })

    fun unregister(context: Context) {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(this)
        currentDownloads.clear()
    }

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

    open fun onCreate(context: Context, download: OfflineDownload) {
        currentDownloads[download.regionId] = download
    }

    open fun onCreateError(context: Context, options: OfflineDownloadOptions, error: String?) {
        // no-op
    }

    open fun onDelete(context: Context, download: OfflineDownload) {
        currentDownloads.remove(download.regionId)
    }

    open fun onDeleteError(context: Context, download: OfflineDownload, error: String?) {
        currentDownloads.remove(download.regionId)
    }

    open fun onStatusChanged(context: Context, download: OfflineDownload) {
        currentDownloads[download.regionId] = download
    }

    open fun onObserverError(context: Context, download: OfflineDownload, reason: String?, message: String?) {
        currentDownloads.remove(download.regionId)
    }

    open fun onTileCountLimitExceeded(context: Context, download: OfflineDownload, limit: Long) {
        currentDownloads.remove(download.regionId)
    }
}