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

class OfflineDownloadJob(
    context: Context,
    options: OfflineDownloadOptions,
    val region: OfflineRegion
) {

    private val notificationDownload: NotificationCompat.Builder =
        NotificationUtils.baseNotificationBuilder(context, options.notificationOptions, region.id)
            .setContentText(context.getString(options.notificationOptions.downloadContentTextRes))
            .addAction(0, context.getString(options.notificationOptions.cancelActionTextRes), PendingIntent.getService(
                context,
                region.id.toInt(),
                OfflineService.createIntent(context, OfflineService.ACTION_CANCEL, region.id),
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
                notificationDownload.setLargeIcon(it.bitmap)
            }
        }

    var download = OfflineDownload(region.id, options)

    fun getNotificationDownload(): Notification =
        notificationDownload.setProgress(100, download.getPercentage(), false).build()

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