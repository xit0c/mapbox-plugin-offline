package dev.micheleferretti.mapboxpluginofflinedemo

import android.app.Application
import com.mapbox.mapboxsdk.Mapbox
import dev.micheleferretti.mapboxpluginoffline.BuildConfig

class DemoApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(this, BuildConfig.MAPBOX_ACCESS_TOKEN)
    }
}