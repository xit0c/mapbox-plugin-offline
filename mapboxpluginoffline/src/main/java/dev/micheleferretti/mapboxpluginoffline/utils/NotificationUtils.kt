package dev.micheleferretti.mapboxpluginoffline.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import dev.micheleferretti.mapboxpluginoffline.model.NotificationOptions

/**
 * This object only purpose is to provide utility methods for notification management.
 */
internal object NotificationUtils {

    private const val CHANNEL_ID = "channel.MAPBOX_OFFLINE_DOWNLOAD"
    private const val CHANNEL_NAME = "Mapbox Offline Download"

    /**
     * Creates a [NotificationChannel] for API 26+.
     * @param context Context used to get the [NotificationManager].
     */
    fun setupNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.getSystemService(NotificationManager::class.java)?.createNotificationChannel(
                NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.GREEN
                    lockscreenVisibility = Notification.VISIBILITY_PRIVATE
                }
            )
        }
    }

    /**
     * Returns a base `NotificationCompat.Builder` with cancel and download notifications common settings.
     * @param context Context used for the builder and the intent.
     * @param notificationOptions Options used as source for the notification data.
     * @param regionId `OfflineRegion` id that will be bundled in the notification content [Intent].
     * @return a base `NotificationCompat.Builder` with cancel and download notifications common settings.
     */
    fun baseNotificationBuilder(context: Context, notificationOptions: NotificationOptions, regionId: Long): NotificationCompat.Builder =
        NotificationCompat.Builder(context, CHANNEL_ID).apply {
            setSmallIcon(notificationOptions.smallIconRes)
            setContentTitle(context.getString(notificationOptions.contentTitleRes))
            setCategory(NotificationCompat.CATEGORY_PROGRESS)
            setOnlyAlertOnce(true)
            if (notificationOptions.returnActivity != null) {
                setContentIntent(PendingIntent.getActivity(
                    context,
                    regionId.toInt(),
                    Intent(context, notificationOptions.returnActivity).apply {
                        putExtra(NotificationOptions.EXTRA_REGION_ID_FOR_ACTIVITY, regionId)
                    },
                    0
                ))
            }
        }
}