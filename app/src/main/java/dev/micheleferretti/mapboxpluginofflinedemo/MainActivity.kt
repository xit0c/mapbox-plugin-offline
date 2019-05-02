package dev.micheleferretti.mapboxpluginofflinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.offline.OfflineTilePyramidRegionDefinition
import dev.micheleferretti.mapboxpluginoffline.BuildConfig
import dev.micheleferretti.mapboxpluginoffline.OfflineService
import dev.micheleferretti.mapboxpluginoffline.model.NotificationOptions
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val receiver = MainReceiver()

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
                Log.d(TAG, "activeDownloads = ${receiver.activeDownloads}")
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
