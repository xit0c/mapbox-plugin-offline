package io.github.xit0c.mapboxpluginoffline.utils

import android.os.Bundle
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.offline.OfflineRegion
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
import com.mapbox.mapboxsdk.offline.OfflineRegionStatus

/**
 * Returns the value associated with the given key, if exists and is of the desired type. Otherwise throws.
 *
 * @param key a String
 * @return a long value
 * @throws ClassCastException
 */
fun Bundle.requireLong(key: String): Long = this.get(key) as Long

/**
 * Returns a `String` representation of this object.
 * @return a `String` representation of this object.
 */
fun OfflineRegion.convertToString() = "OfflineRegion(" +
        "id=$id, " +
        "name=${getName()}, " +
        "definition=${definition.convertToString()}, " +
        "isDeliveringInactiveMessages=$isDeliveringInactiveMessages" +
        ")"

/**
 * Returns the region name converting `metadata` with [OfflineUtils.convertRegionName].
 * @return the region name converting `metadata` with [OfflineUtils.convertRegionName].
 */
fun OfflineRegion.getName() = OfflineUtils.convertRegionName(metadata)

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

/**
 * Returns the `OfflineRegionStatus` resources completion percentage.
 * @return the `OfflineRegionStatus` resources completion percentage.
 */
fun OfflineRegionStatus.getCompletionPercentage() =
    OfflineUtils.getCompletionPercentage(completedResourceCount, requiredResourceCount)