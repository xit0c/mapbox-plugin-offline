package io.github.xit0c.mapboxpluginoffline.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import io.github.xit0c.mapboxpluginoffline.utils.OfflineUtils
import kotlinx.parcelize.Parcelize

/**
 * This model represents the options for the notification shown by
 * the [OfflineService][io.github.xit0c.mapboxpluginoffline.OfflineService].
 *
 * @property smallIconRes [DrawableRes] id of the notification small icon.
 * @property contentTitle notification content title.
 * @property downloadContentText notification content text shown during download.
 * @property cancelContentText notification content text shown during cancellation.
 * @property cancelActionText notification action text for download cancellation.
 * @property requestMapSnapshot Whether or not to add a map snapshot of the region as the notification large icon.
 * @property returnActivity The activity to start on notification tap.
 * @constructor Creates a `NotificationOptions` with the given values.
 */
@Parcelize
class NotificationOptions @JvmOverloads constructor(
    @DrawableRes val smallIconRes: Int = android.R.drawable.stat_sys_download,
    val contentTitle: String = "Offline Map",
    val downloadContentText: String = "Downloading…",
    val cancelContentText: String = "Deleting…",
    val cancelActionText: String = "Cancel",
    val requestMapSnapshot: Boolean = true,
    val returnActivity: Class<*>? = null
): Parcelable {
    companion object {

        /**
         * Key for the `OfflineRegion` id put as an extra of the Intent used to start [returnActivity].
         * @see OfflineUtils.getRegionIdFromIntent
         */
        const val EXTRA_REGION_ID_FOR_ACTIVITY = "extra.REGION_ID_FOR_ACTIVITY"
    }

    /**
     * Returns a `String` representation of this object.
     * @return a `String` representation of this object.
     */
    override fun toString(): String = "NotificationOptions(" +
            "smallIconRes=$smallIconRes, " +
            "contentTitle='$contentTitle', " +
            "downloadContentText='$downloadContentText', " +
            "cancelContentText='$cancelContentText', " +
            "cancelActionText='$cancelActionText', " +
            "requestMapSnapshot=$requestMapSnapshot, " +
            "returnActivity=$returnActivity" +
            ")"
}