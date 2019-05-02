package dev.micheleferretti.mapboxpluginoffline.utils

import android.util.Log
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
import org.json.JSONObject
import java.lang.Exception

object OfflineUtils {

    private const val TAG = "OfflineUtils"

    private const val KEY_REGION_NAME = "key.REGION_NAME"

    fun convertRegionName(regionName: String) = try {
        JSONObject().put(KEY_REGION_NAME, regionName).toString().toByteArray()
    } catch (e: Exception) {
        Log.e(TAG, "regionName: conversion from String to ByteArray failed", e)
        null
    }

    fun convertRegionName(regionName: ByteArray?) = try {
        if (regionName != null) JSONObject(String(regionName)).getString(KEY_REGION_NAME) else null
    } catch (e: Exception) {
        Log.e(TAG, "regionName: conversion from ByteArray to String failed", e)
        null
    }

    fun getCameraPosition(definition: OfflineRegionDefinition) =
        CameraPosition.Builder().target(definition.bounds.center).zoom(definition.minZoom).build()
}