package io.github.xit0c.mapboxpluginofflinedemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.offline.OfflineTilePyramidRegionDefinition
import io.github.xit0c.mapboxpluginoffline.OfflineDownloadReceiver
import io.github.xit0c.mapboxpluginoffline.OfflineService
import io.github.xit0c.mapboxpluginoffline.model.NotificationOptions
import io.github.xit0c.mapboxpluginoffline.model.OfflineDownload
import io.github.xit0c.mapboxpluginoffline.model.OfflineDownloadOptions
import io.github.xit0c.mapboxpluginofflinedemo.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDemoBinding

    private val logAdapter = LogAdapter()
    private val receiver = Receiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activeDownloadsBtn.setOnClickListener(this)
        binding.downloadBtn.setOnClickListener(this)
        binding.logsRv.apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
            adapter = logAdapter
        }

        binding.map.onCreate(savedInstanceState)
        binding.map.getMapAsync { it.setStyle(Style.MAPBOX_STREETS) }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.active_downloads_btn -> {
                logAdapter.addLog(LogMessage.Plain("onClick", "activeDownloads = ${receiver.getActiveDownloads()}"))
                Toast.makeText(v.context, "Count: ${receiver.getActiveDownloads().size}", Toast.LENGTH_SHORT).show()
            }
            R.id.download_btn -> {
                binding.map.getMapAsync {
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
        binding.map.onStart()
        receiver.register(this)
    }

    override fun onResume() {
        super.onResume()
        binding.map.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.map.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.map.onStop()
        receiver.unregister(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.map.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.map.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.map.onDestroy()
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
