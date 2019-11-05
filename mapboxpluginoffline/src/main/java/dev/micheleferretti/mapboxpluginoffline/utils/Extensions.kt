package dev.micheleferretti.mapboxpluginoffline.utils

import android.os.Bundle
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition

/**
 * Returns the value associated with the given key, if exists and is of the desired type. Otherwise throws.
 *
 * @param key a String
 * @return a long value
 * @throws IllegalArgumentException
 */
fun Bundle.requireLong(key: String): Long =
    this.get(key) as? Long ?: throw IllegalArgumentException("Required value is missing or not a Long")

/**
 * Returns a `String` representation of this object.
 * @return a `String` representation of this object.
 */
fun OfflineRegionDefinition.convertToString() = "OfflineRegionDefinition(" +
        "styleURL=$styleURL, " +
        "type=$type, " +
        "includeIdeographs=$includeIdeographs, " +
        "pixelRatio=$pixelRatio, " +
        "minZoom=$minZoom, " +
        "maxZoom=$maxZoom, " +
        "bounds=$bounds" +
        ")"

/**
 * Returns a `CameraPosition` built with this definition data.
 * @return a `CameraPosition` built with this definition data.
 */
fun OfflineRegionDefinition.getCameraPosition() =
    CameraPosition.Builder().target(bounds.center).zoom(minZoom).build()