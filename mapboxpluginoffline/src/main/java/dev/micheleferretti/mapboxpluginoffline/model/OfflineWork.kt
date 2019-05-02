package dev.micheleferretti.mapboxpluginoffline.model

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat
import com.mapbox.mapboxsdk.offline.OfflineRegion
import com.mapbox.mapboxsdk.offline.OfflineRegionStatus
import com.mapbox.mapboxsdk.snapshotter.MapSnapshotter
import dev.micheleferretti.mapboxpluginoffline.OfflineService
import dev.micheleferretti.mapboxpluginoffline.utils.NotificationUtils

class OfflineWork(
    context: Context,
    options: OfflineDownloadOptions,
    val region: OfflineRegion
) {

    private val notificationPause: NotificationCompat.Builder =
        NotificationUtils.cancelableNotificationBuilder(context, options.notificationOptions, region.id)
            .setContentText(context.getString(options.notificationOptions.pauseContentTextRes))
            .addAction(0, context.getString(options.notificationOptions.resumeActionTextRes), PendingIntent.getService(
                context,
                region.id.toInt(),
                OfflineService.createIntent(context, OfflineService.ACTION_RESUME, region.id),
                0
            ))

    private val notificationResume: NotificationCompat.Builder =
        NotificationUtils.cancelableNotificationBuilder(context, options.notificationOptions, region.id)
            .setContentText(context.getString(options.notificationOptions.downloadContentTextRes))
            .addAction(0, context.getString(options.notificationOptions.pauseActionTextRes), PendingIntent.getService(
                context,
                region.id.toInt(),
                OfflineService.createIntent(context, OfflineService.ACTION_PAUSE, region.id),
                0
            ))

    val notificationCancel: NotificationCompat.Builder =
        NotificationUtils.baseNotificationBuilder(context, options.notificationOptions, region.id)
            .setContentText(context.getString(options.notificationOptions.cancelContentTextRes))
            .setProgress(100, 0, true)

    val snapshotter: MapSnapshotter? = if (!options.notificationOptions.requestMapSnapshot) null else
        MapSnapshotter(context, MapSnapshotter.Options(
            context.resources.getDimension(android.R.dimen.notification_large_icon_width).toInt(),
            context.resources.getDimension(android.R.dimen.notification_large_icon_height).toInt()
        ).apply {
            withStyle(options.definition.styleURL)
            withRegion(options.definition.bounds)
        }).apply {
            start {
                notificationCancel.setLargeIcon(it.bitmap)
                notificationPause.setLargeIcon(it.bitmap)
                notificationResume.setLargeIcon(it.bitmap)
            }
        }

    var download = OfflineDownload(region.id, options)

    fun getNotificationPause(): Notification =
        notificationPause.setProgress(100, download.getPercentage(), false).build()

    fun getNotificationResume(): Notification =
        notificationResume.setProgress(100, download.getPercentage(), false).build()

    fun updateDownload(status: OfflineRegionStatus) {
        download = OfflineDownload(
            download.regionId,
            download.options,
            status.completedResourceCount,
            status.requiredResourceCount,
            status.completedResourceSize,
            status.downloadState == OfflineRegion.STATE_ACTIVE
        )
    }
}