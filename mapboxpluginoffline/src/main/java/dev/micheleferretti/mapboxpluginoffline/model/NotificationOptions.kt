package dev.micheleferretti.mapboxpluginoffline.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.micheleferretti.mapboxpluginoffline.R
import kotlinx.android.parcel.Parcelize

/**
 * This model represents the options for the notification shown by
 * the [OfflineService][dev.micheleferretti.mapboxpluginoffline.OfflineService].
 *
 * @property smallIconRes [DrawableRes] id of the notification small icon.
 * @property contentTitleRes [StringRes] id of the notification content title.
 * @property downloadContentTextRes [StringRes] id of the notification content text, shown during download.
 * @property cancelContentTextRes [StringRes] id of the notification content text, shown during cancellation.
 * @property cancelActionTextRes [StringRes] id of the notification action text for download cancellation.
 * @property requestMapSnapshot Whether or not to add a map snapshot of the region as the notification large icon.
 * @property returnActivity The activity to start on notification tap.
 * @constructor Creates a `NotificationOptions` with the given values.
 */
@Parcelize
class NotificationOptions @JvmOverloads constructor(
    @DrawableRes val smallIconRes: Int = DEFAULT_SMALL_ICON_RES,
    @StringRes val contentTitleRes: Int = DEFAULT_CONTENT_TITLE_RES,
    @StringRes val downloadContentTextRes: Int = DEFAULT_DOWNLOAD_CONTENT_TEXT_RES,
    @StringRes val cancelContentTextRes: Int = DEFAULT_CANCEL_CONTENT_TEXT_RES,
    @StringRes val cancelActionTextRes: Int = DEFAULT_CANCEL_ACTION_TEXT_RES,
    val requestMapSnapshot: Boolean = DEFAULT_REQUEST_MAP_SNAPSHOT,
    val returnActivity: Class<*>? = DEFAULT_RETURN_ACTIVITY
): Parcelable {
    companion object {
        private const val DEFAULT_SMALL_ICON_RES = android.R.drawable.stat_sys_download
        private val DEFAULT_CONTENT_TITLE_RES = R.string.notification_default_content_title
        private val DEFAULT_DOWNLOAD_CONTENT_TEXT_RES = R.string.notification_default_content_text_download
        private val DEFAULT_CANCEL_CONTENT_TEXT_RES = R.string.notification_default_content_text_cancel
        private val DEFAULT_CANCEL_ACTION_TEXT_RES = R.string.notification_default_action_cancel
        private const val DEFAULT_REQUEST_MAP_SNAPSHOT = true
        private val DEFAULT_RETURN_ACTIVITY = null

        /**
         * Key for the `OfflineRegion` id put as an extra of the Intent used to start [returnActivity].
         * @see dev.micheleferretti.mapboxpluginoffline.utils.OfflineUtils.getRegionIdFromIntent
         */
        const val EXTRA_REGION_ID_FOR_ACTIVITY = "extra.REGION_ID_FOR_ACTIVITY"
    }

    /**
     * Returns a `String` representation of this object.
     * @return a `String` representation of this object.
     */
    override fun toString() = "NotificationOptions(" +
            "requestMapSnapshot=$requestMapSnapshot, " +
            "returnActivity=$returnActivity" +
            ")"
}