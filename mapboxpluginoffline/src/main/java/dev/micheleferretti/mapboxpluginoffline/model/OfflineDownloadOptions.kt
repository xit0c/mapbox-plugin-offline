package dev.micheleferretti.mapboxpluginoffline.model

import android.os.Parcelable
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
import dev.micheleferretti.mapboxpluginoffline.utils.OfflineUtils
import dev.micheleferretti.mapboxpluginoffline.utils.convertToString
import kotlinx.android.parcel.Parcelize

/**
 * This model represents the options for the download managed by
 * the [OfflineService][dev.micheleferretti.mapboxpluginoffline.OfflineService].
 *
 * @property definition Region definition that will be used in `OfflineManager.createOfflineRegion()`.
 * @property notificationOptions Options that will be used for the notification shown by
 * the [OfflineService][dev.micheleferretti.mapboxpluginoffline.OfflineService].
 * @property metadata Region metadata that will be used in `OfflineManager.createOfflineRegion()`.
 * @constructor Creates a `OfflineDownloadOptions` with the given values.
 */
@Parcelize
class OfflineDownloadOptions(
    val definition: OfflineRegionDefinition,
    val notificationOptions: NotificationOptions,
    val metadata: ByteArray?
): Parcelable {

    /**
     * Creates a `OfflineDownloadOptions` with the given values,
     * converting [regionName] to a `ByteArray` with [OfflineUtils.convertRegionName].
     */
    constructor(
        definition: OfflineRegionDefinition,
        notificationOptions: NotificationOptions,
        regionName: String
    ) : this(definition, notificationOptions, OfflineUtils.convertRegionName(regionName))

    /**
     * Returns the region name converting [metadata] with [OfflineUtils.convertRegionName].
     * @return the region name converting [metadata] with [OfflineUtils.convertRegionName].
     */
    fun getRegionName() = OfflineUtils.convertRegionName(metadata)

    /**
     * Returns a `String` representation of this object.
     * @return a `String` representation of this object.
     */
    override fun toString() = "OfflineDownloadOptions(" +
            "definition=${definition.convertToString()}, " +
            "notificationOptions=$notificationOptions, " +
            "metadata=${metadata?.contentToString()}" +
            ")"
}