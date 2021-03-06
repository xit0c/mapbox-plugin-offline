package io.github.xit0c.mapboxpluginoffline.utils

import android.content.Intent
import android.util.Log
import io.github.xit0c.mapboxpluginoffline.model.NotificationOptions
import io.github.xit0c.mapboxpluginoffline.model.OfflineDownloadOptions
import org.json.JSONObject
import java.lang.Exception

/**
 * This object only purpose is to provide utility methods.
 */
object OfflineUtils {

    private const val TAG = "OfflineUtils"

    private const val KEY_REGION_NAME = "key.REGION_NAME"

    /**
     * Converts `regionName` to a `ByteArray`. Useful to store the name of a region as metadata.
     * @return the region name converted to a `ByteArray`.
     * @see OfflineDownloadOptions.metadata
     * @see OfflineDownloadOptions.getRegionName
     */
    fun convertRegionName(regionName: String): ByteArray? = try {
        JSONObject().put(KEY_REGION_NAME, regionName).toString().toByteArray()
    } catch (e: Exception) {
        Log.e(TAG, "regionName: conversion from String to ByteArray failed", e)
        null
    }

    /**
     * Converts `regionName` to a plain `String`. Useful to retrieve the name of a region from metadata.
     * @return the region name converted to a `String`.
     * @see OfflineDownloadOptions.metadata
     * @see OfflineDownloadOptions.getRegionName
     */
    fun convertRegionName(regionName: ByteArray?): String? = try {
        if (regionName != null) JSONObject(String(regionName)).getString(KEY_REGION_NAME) else null
    } catch (e: Exception) {
        Log.e(TAG, "regionName: conversion from ByteArray to String failed", e)
        null
    }

    /**
     * Returns the resources completion percentage.
     * @param completedResourceCount number of resources that have been fully download.
     * @param requiredResourceCount number of resources that are known to be required.
     * @return the resources completion percentage.
     */
    fun getCompletionPercentage(completedResourceCount: Long, requiredResourceCount: Long) =
        (if (requiredResourceCount > 0) 100.0 * completedResourceCount / requiredResourceCount else 0.0).toInt()

    /**
     * Returns the region id contained in `intent.extras`, if any.
     * @return the region id contained in `intent.extras`, if any.
     * @see NotificationOptions.returnActivity
     * @see NotificationOptions.EXTRA_REGION_ID_FOR_ACTIVITY
     */
    fun getRegionIdFromIntent(intent: Intent) =
        intent.extras?.get(NotificationOptions.EXTRA_REGION_ID_FOR_ACTIVITY) as? Long
}