package dev.micheleferretti.mapboxpluginofflinedemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.offline.OfflineTilePyramidRegionDefinition
import dev.micheleferretti.mapboxpluginoffline.BuildConfig
import dev.micheleferretti.mapboxpluginoffline.OfflineDownloadReceiver
import dev.micheleferretti.mapboxpluginoffline.OfflineService
import dev.micheleferretti.mapboxpluginoffline.model.NotificationOptions
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val receiver = object : OfflineDownloadReceiver() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, BuildConfig.MAPBOX_ACCESS_TOKEN)

        setContentView(R.layout.activity_main)

        active_downloads_btn.setOnClickListener(this)
        download_btn.setOnClickListener(this)

        map?.onCreate(savedInstanceState)
        map?.getMapAsync { it.setStyle(Style.MAPBOX_STREETS) }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.active_downloads_btn -> {
                Log.d(TAG, "currentDownloads = ${receiver.currentDownloads}")
            }
            R.id.download_btn -> {
                map?.getMapAsync {
                    OfflineService.startDownload(this, OfflineDownloadOptions(
                        OfflineTilePyramidRegionDefinition(
                            Style.MAPBOX_STREETS,
                            it.cameraPosition.target.let { latlng ->
                                LatLngBounds.from(
                                    latlng.latitude + 0.005,
                                    latlng.longitude + 0.005,
                                    latlng.latitude - 0.005,
                                    latlng.longitude - 0.005
                                )
                            },
                            12.0,
                            15.0,
                            resources.displayMetrics.density
                        ),
                        NotificationOptions(returnActivity = MainActivity::class.java),
                        null
                    ))
                }
            }
        }
    }

    // Lifecycle methods

    override fun onStart() {
        super.onStart()
        map?.onStart()
        receiver.register(this)
    }

    override fun onResume() {
        super.onResume()
        map?.onResume()
    }

    override fun onPause() {
        super.onPause()
        map?.onPause()
    }

    override fun onStop() {
        super.onStop()
        map?.onStop()
        receiver.unregister(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        map?.onSaveInstanceState(outState ?: Bundle())
    }

    override fun onLowMemory() {
        super.onLowMemory()
        map?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        map?.onDestroy()
    }
}
