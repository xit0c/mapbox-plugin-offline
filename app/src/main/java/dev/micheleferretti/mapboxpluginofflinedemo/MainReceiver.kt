package dev.micheleferretti.mapboxpluginofflinedemo

import android.content.Context
import android.util.Log
import dev.micheleferretti.mapboxpluginoffline.OfflineDownloadReceiver
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions

class MainReceiver : OfflineDownloadReceiver() {

    companion object {
        private const val TAG = "MainReceiver"
    }

    override fun onCreate(context: Context, download: OfflineDownload) {
        super.onCreate(context, download)
        Log.d(TAG, "onCreate: download = $download")
    }

    override fun onCreateError(context: Context, options: OfflineDownloadOptions, error: String?) {
        super.onCreateError(context, options, error)
        Log.d(TAG, "onCreateError: options = $options")
    }

    override fun onDelete(context: Context, download: OfflineDownload) {
        super.onDelete(context, download)
        Log.d(TAG, "onDelete: download = $download")
    }

    override fun onDeleteError(context: Context, download: OfflineDownload, error: String?) {
        super.onDeleteError(context, download, error)
        Log.d(TAG, "onDeleteError: download = $download, error = $error")
    }

    override fun onStatusChanged(context: Context, download: OfflineDownload) {
        super.onStatusChanged(context, download)
        Log.d(TAG, "onStatusChanged: download = $download")
    }

    override fun onObserverError(context: Context, download: OfflineDownload, reason: String?, message: String?) {
        super.onObserverError(context, download, reason, message)
        Log.d(TAG, "onObserverError: download = $download, reason = $reason, message = $message")
    }

    override fun onTileCountLimitExceeded(context: Context, download: OfflineDownload, limit: Long) {
        super.onTileCountLimitExceeded(context, download, limit)
        Log.d(TAG, "onTileCountLimitExceeded: download = $download, limit = $limit")
    }

}