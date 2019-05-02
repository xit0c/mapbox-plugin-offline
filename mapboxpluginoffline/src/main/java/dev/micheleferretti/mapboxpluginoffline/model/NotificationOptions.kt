package dev.micheleferretti.mapboxpluginoffline.model

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.micheleferretti.mapboxpluginoffline.R

class NotificationOptions @JvmOverloads constructor(
    @DrawableRes val smallIconRes: Int = DEFAULT_SMALL_ICON_RES,
    @StringRes val contentTitleRes: Int = DEFAULT_CONTENT_TITLE_RES,
    @StringRes val downloadContentTextRes: Int = DEFAULT_DOWNLOAD_CONTENT_TEXT_RES,
    @StringRes val cancelContentTextRes: Int = DEFAULT_CANCEL_CONTENT_TEXT_RES,
    @StringRes val pauseContentTextRes: Int = DEFAULT_PAUSE_CONTENT_TEXT_RES,
    @StringRes val cancelActionTextRes: Int = DEFAULT_CANCEL_ACTION_TEXT_RES,
    @StringRes val pauseActionTextRes: Int = DEFAULT_PAUSE_ACTION_TEXT_RES,
    @StringRes val resumeActionTextRes: Int = DEFAULT_RESUME_ACTION_TEXT_RES,
    val requestMapSnapshot: Boolean = DEFAULT_REQUEST_MAP_SNAPSHOT,
    val returnActivity: Class<*>? = DEFAULT_RETURN_ACTIVITY
) {
    companion object {
        private const val DEFAULT_SMALL_ICON_RES = android.R.drawable.stat_sys_download
        private val DEFAULT_CONTENT_TITLE_RES = R.string.notification_default_content_title
        private val DEFAULT_DOWNLOAD_CONTENT_TEXT_RES = R.string.notification_default_content_text_download
        private val DEFAULT_CANCEL_CONTENT_TEXT_RES = R.string.notification_default_content_text_cancel
        private val DEFAULT_PAUSE_CONTENT_TEXT_RES = R.string.notification_default_content_text_pause
        private val DEFAULT_CANCEL_ACTION_TEXT_RES = R.string.notification_default_action_cancel
        private val DEFAULT_PAUSE_ACTION_TEXT_RES = R.string.notification_default_action_pause
        private val DEFAULT_RESUME_ACTION_TEXT_RES = R.string.notification_default_action_resume
        private const val DEFAULT_REQUEST_MAP_SNAPSHOT = true
        private val DEFAULT_RETURN_ACTIVITY = null

        private const val EXTRA_SMALL_ICON_RES = "extra.SMALL_ICON_RES"
        private const val EXTRA_CONTENT_TITLE_RES = "extra.CONTENT_TITLE_RES"
        private const val EXTRA_DOWNLOAD_CONTENT_TEXT_RES = "extra.DOWNLOAD_CONTENT_TEXT_RES"
        private const val EXTRA_CANCEL_CONTENT_TEXT_RES = "extra.CANCEL_CONTENT_TEXT_RES"
        private const val EXTRA_PAUSE_CONTENT_TEXT_RES = "extra.PAUSE_CONTENT_TEXT_RES"
        private const val EXTRA_CANCEL_ACTION_TEXT_RES = "extra.CANCEL_ACTION_TEXT_RES"
        private const val EXTRA_PAUSE_ACTION_TEXT_RES = "extra.PAUSE_ACTION_TEXT_RES"
        private const val EXTRA_RESUME_ACTION_TEXT_RES = "extra.RESUME_ACTION_TEXT_RES"
        private const val EXTRA_REQUEST_MAP_SNAPSHOT = "extra.REQUEST_MAP_SNAPSHOT"
        private const val EXTRA_RETURN_ACTIVITY = "extra.RETURN_ACTIVITY"

        fun fromBundle(b: Bundle) = NotificationOptions(
            b.getInt(EXTRA_SMALL_ICON_RES, DEFAULT_SMALL_ICON_RES),
            b.getInt(EXTRA_CONTENT_TITLE_RES, DEFAULT_CONTENT_TITLE_RES),
            b.getInt(EXTRA_DOWNLOAD_CONTENT_TEXT_RES, DEFAULT_DOWNLOAD_CONTENT_TEXT_RES),
            b.getInt(EXTRA_CANCEL_CONTENT_TEXT_RES, DEFAULT_CANCEL_CONTENT_TEXT_RES),
            b.getInt(EXTRA_PAUSE_CONTENT_TEXT_RES, DEFAULT_PAUSE_CONTENT_TEXT_RES),
            b.getInt(EXTRA_CANCEL_ACTION_TEXT_RES, DEFAULT_CANCEL_ACTION_TEXT_RES),
            b.getInt(EXTRA_PAUSE_ACTION_TEXT_RES, DEFAULT_PAUSE_ACTION_TEXT_RES),
            b.getInt(EXTRA_RESUME_ACTION_TEXT_RES, DEFAULT_RESUME_ACTION_TEXT_RES),
            b.getBoolean(EXTRA_REQUEST_MAP_SNAPSHOT, DEFAULT_REQUEST_MAP_SNAPSHOT),
            b.getSerializable(EXTRA_RETURN_ACTIVITY) as? Class<*>
        )
    }

    fun toBundle() = Bundle().apply {
        putInt(EXTRA_SMALL_ICON_RES, smallIconRes)
        putInt(EXTRA_CONTENT_TITLE_RES, contentTitleRes)
        putInt(EXTRA_DOWNLOAD_CONTENT_TEXT_RES, downloadContentTextRes)
        putInt(EXTRA_CANCEL_CONTENT_TEXT_RES, cancelContentTextRes)
        putInt(EXTRA_PAUSE_CONTENT_TEXT_RES, pauseContentTextRes)
        putInt(EXTRA_CANCEL_ACTION_TEXT_RES, cancelActionTextRes)
        putInt(EXTRA_PAUSE_ACTION_TEXT_RES, pauseActionTextRes)
        putInt(EXTRA_RESUME_ACTION_TEXT_RES, resumeActionTextRes)
        putBoolean(EXTRA_REQUEST_MAP_SNAPSHOT, requestMapSnapshot)
        putSerializable(EXTRA_RETURN_ACTIVITY, returnActivity)
    }

    override fun toString() = "NotificationOptions(" +
            "smallIconRes=$smallIconRes, " +
            "contentTitleRes=$contentTitleRes, " +
            "downloadContentTextRes=$downloadContentTextRes, " +
            "cancelContentTextRes=$cancelContentTextRes, " +
            "pauseContentTextRes=$pauseContentTextRes, " +
            "cancelActionTextRes=$cancelActionTextRes, " +
            "pauseActionTextRes=$pauseActionTextRes, " +
            "resumeActionTextRes=$resumeActionTextRes, " +
            "requestMapSnapshot=$requestMapSnapshot, " +
            "returnActivity=$returnActivity" +
            ")"
}