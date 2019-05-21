package dev.micheleferretti.mapboxpluginofflinedemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    private val logAdapter = LogAdapter()
    private val receiver = Receiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, BuildConfig.MAPBOX_ACCESS_TOKEN)

        setContentView(R.layout.activity_main)

        active_downloads_btn.setOnClickListener(this)
        download_btn.setOnClickListener(this)
        logs_rv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
            adapter = logAdapter
        }

        map?.onCreate(savedInstanceState)
        map?.getMapAsync { it.setStyle(Style.MAPBOX_STREETS) }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.active_downloads_btn -> {
                logAdapter.addLog(LogMessage.Plain("onClick", "activeDownloads = ${receiver.getActiveDownloads()}"))
                Toast.makeText(v.context, "Count: ${receiver.getActiveDownloads().size}", Toast.LENGTH_SHORT).show()
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
                        NotificationOptions(),
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

    // Receiver class

    inner class Receiver : OfflineDownloadReceiver() {

        override fun onCreate(context: Context, download: OfflineDownload) {
            super.onCreate(context, download)
            logAdapter.addLog(LogMessage.Create(download))
        }

        override fun onCreateError(context: Context, options: OfflineDownloadOptions, error: String?) {
            super.onCreateError(context, options, error)
            logAdapter.addLog(LogMessage.Error("onCreateError", "options = $options, error = $error"))
        }

        override fun onDelete(context: Context, download: OfflineDownload) {
            super.onDelete(context, download)
            logAdapter.addLog(LogMessage.Delete(download))
        }

        override fun onDeleteError(context: Context, download: OfflineDownload, error: String?) {
            super.onDeleteError(context, download, error)
            logAdapter.addLog(LogMessage.Error("onDeleteError", "regionId = ${download.regionId}, error = $error"))
        }

        override fun onStatusChanged(context: Context, download: OfflineDownload) {
            super.onStatusChanged(context, download)
            logAdapter.addLog(LogMessage.StatusChanged(download))
        }

        override fun onObserverError(context: Context, download: OfflineDownload, reason: String?, message: String?) {
            super.onObserverError(context, download, reason, message)
            logAdapter.addLog(LogMessage.Error("onObserverError", "regionId = ${download.regionId}, reason = $reason, message = $message"))
        }

        override fun onTileCountLimitExceeded(context: Context, download: OfflineDownload, limit: Long) {
            super.onTileCountLimitExceeded(context, download, limit)
            logAdapter.addLog(LogMessage.Error("onTileCountLimitExceeded", "regionId = ${download.regionId}, limit = $limit"))
        }
    }
}
