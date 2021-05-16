package io.github.xit0c.mapboxpluginofflinedemo

import android.app.Application
import com.mapbox.mapboxsdk.Mapbox

class DemoApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(this, BuildConfig.MAPBOX_ACCESS_TOKEN)
    }
}