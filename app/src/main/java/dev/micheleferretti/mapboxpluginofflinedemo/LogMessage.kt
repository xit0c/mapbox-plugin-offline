package dev.micheleferretti.mapboxpluginofflinedemo

import androidx.annotation.ColorRes
import dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload
import java.text.SimpleDateFormat
import java.util.*

sealed class LogMessage(val tag: String, val message: String, @ColorRes val color: Int) {

    companion object {
        private val dateFormatter = SimpleDateFormat("yyyy-MM-dd HH.mm.ss", Locale.US)
    }

    val formattedMessage = "${dateFormatter.format(Date())} - $tag: $message"

    class Plain(tag: String, message: String): LogMessage(tag, message, android.R.color.black)

    class Create(download: OfflineDownload): LogMessage(
            "onCreate",
            "download = $download",
            android.R.color.holo_green_dark
    )

    class StatusChanged(download: OfflineDownload): LogMessage(
            "onStatusChanged",
            "regionId = ${download.regionId}, " +
                    "percentage = ${download.getPercentage()}, " +
                    "isActive = ${download.isActive()}, " +
                    "isComplete = ${download.isComplete()}",
            android.R.color.holo_blue_dark
    )

    class Delete(download: OfflineDownload): LogMessage(
            "onDelete",
            "regionId = ${download.regionId}",
            android.R.color.holo_orange_dark
    )

    class Error(tag: String, message: String): LogMessage(tag, message, android.R.color.holo_red_dark)
}