package dev.micheleferretti.mapboxpluginoffline.model

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.offline.OfflineRegion
import com.mapbox.mapboxsdk.snapshotter.MapSnapshotter
import dev.micheleferretti.mapboxpluginoffline.OfflineService
import dev.micheleferretti.mapboxpluginoffline.utils.NotificationUtils

/**
 * This model is for internal usage only and represents a download "job" managed by the [OfflineService].
 *
 * It holds all the objects related to a single download: the `region` to download, the notification builders
 * (`notificationDownload` and `notificationCancel`) for download and cancel operations and the `snapshotter`
 * (if requested) that generates the bitmaps used as notifications' large icons.
 *
 * @param context Context used for notifications and snapshotter.
 * @param options Options used to start the download.
 * @property region The `OfflineRegion` to download.
 * @constructor Creates a `OfflineDownloadJob` with the given values.
 */
internal class OfflineDownloadJob(
    context: Context,
    options: OfflineDownloadOptions,
    val region: OfflineRegion
) {

    private val notificationCancel: NotificationCompat.Builder =
        NotificationUtils.baseNotificationBuilder(context, options.notificationOptions, region.id)
            .setContentText(options.notificationOptions.cancelContentText)
            .setProgress(100, 0, true)

    private val notificationDownload: NotificationCompat.Builder =
        NotificationUtils.baseNotificationBuilder(context, options.notificationOptions, region.id)
            .setContentText(options.notificationOptions.downloadContentText)
            .addAction(0, options.notificationOptions.cancelActionText, PendingIntent.getService(
                context,
                region.id.toInt(),
                OfflineService.createIntent(context, OfflineService.ACTION_CANCEL, region.id),
                0
            ))

    private val snapshotter: MapSnapshotter? = if (!options.notificationOptions.requestMapSnapshot) null else
        MapSnapshotter(context, MapSnapshotter.Options(
            context.resources.getDimension(android.R.dimen.notification_large_icon_width).toInt(),
            context.resources.getDimension(android.R.dimen.notification_large_icon_height).toInt()
        ).apply {
            withStyleBuilder(Style.Builder().fromUri(options.definition.styleURL))
            withRegion(options.definition.bounds)
        }).apply {
            start {
                notificationCancel.setLargeIcon(it.bitmap)
                notificationDownload.setLargeIcon(it.bitmap)
            }
        }

    /**
     * The `OfflineDownload` instance.
     */
    val download = OfflineDownload(region.id, options)

    /**
     * Calls `MapSnapshotter.cancel()` method of the snapshotter instance.
     */
    fun cancelSnapshotter() = snapshotter?.cancel()

    /**
     * Returns the `Notification` to show during cancellation.
     * @return the `Notification` to show during cancellation.
     */
    fun getNotificationCancel(): Notification =
        notificationCancel.build()

    /**
     * Returns the `Notification` to show during download.
     * @return the `Notification` to show during download.
     */
    fun getNotificationDownload(): Notification =
        notificationDownload.setProgress(100, download.getPercentage(), false).build()
}