package dev.micheleferretti.mapboxpluginoffline.utils

import android.os.Bundle
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition

fun Bundle.requireBoolean(key: String): Boolean {
    if (this.containsKey(key)) return this.getBoolean(key) else throw IllegalArgumentException("Required value is missing")
}

fun Bundle.requireLong(key: String): Long {
    if (this.containsKey(key)) return this.getLong(key) else throw IllegalArgumentException("Required value is missing")
}

fun OfflineRegionDefinition.convertToString() = "OfflineRegionDefinition(" +
        "styleURL=$styleURL, " +
        "type=$type, " +
        "includeIdeographs=$includeIdeographs, " +
        "pixelRatio=$pixelRatio, " +
        "minZoom=$minZoom, " +
        "maxZoom=$maxZoom, " +
        "bounds=$bounds" +
        ")"