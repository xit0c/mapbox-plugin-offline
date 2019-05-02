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
import dev.micheleferretti.mapboxpluginoffline.OfflineService
import dev.micheleferretti.mapboxpluginoffline.model.NotificationOptions

object NotificationUtils {

    const val EXTRA_REGION_ID = "extra.REGION_ID"

    private const val CHANNEL_ID = "channel.MAPBOX_OFFLINE_DOWNLOAD"
    private const val CHANNEL_NAME = "Mapbox Offline Download"

    fun setupNotificationChannel(context: Context) {
        // Create notification channel for API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.getSystemService(NotificationManager::class.java)?.createNotificationChannel(
                NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.GREEN
                    lockscreenVisibility = Notification.VISIBILITY_PRIVATE
                }
            )
        }
    }

    fun baseNotificationBuilder(context: Context, notificationOptions: NotificationOptions, regionId: Long): NotificationCompat.Builder =
        NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(notificationOptions.smallIconRes)
            .setContentTitle(context.getString(notificationOptions.contentTitleRes))
            .setContentIntent(PendingIntent.getActivity(
                context,
                regionId.toInt(),
                Intent(context, notificationOptions.returnActivity).apply { putExtra(EXTRA_REGION_ID, regionId) },
                0
            ))
            .setCategory(NotificationCompat.CATEGORY_PROGRESS)
            .setOnlyAlertOnce(true)

    fun cancelableNotificationBuilder(context: Context, notificationOptions: NotificationOptions, regionId: Long): NotificationCompat.Builder =
        baseNotificationBuilder(context, notificationOptions, regionId)
            .addAction(0, context.getString(notificationOptions.cancelActionTextRes), PendingIntent.getService(
                context,
                regionId.toInt(),
                OfflineService.createIntent(context, OfflineService.ACTION_CANCEL, regionId),
                0
            ))
}