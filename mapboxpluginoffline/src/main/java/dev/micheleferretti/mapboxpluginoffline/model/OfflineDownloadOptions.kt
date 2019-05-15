package dev.micheleferretti.mapboxpluginoffline.model

import android.os.Bundle
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
import dev.micheleferretti.mapboxpluginoffline.utils.OfflineUtils
import dev.micheleferretti.mapboxpluginoffline.utils.convertToString

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
class OfflineDownloadOptions(
    val definition: OfflineRegionDefinition,
    val notificationOptions: NotificationOptions,
    val metadata: ByteArray?
) {
    companion object {
        private const val EXTRA_DEFINITION = "extra.DEFINITION"
        private const val EXTRA_NOTIFICATION_OPTIONS = "extra.NOTIFICATION_OPTIONS"
        private const val EXTRA_METADATA = "extra.METADATA"

        /**
         * Creates a `OfflineDownloadOptions` from a `Bundle`.
         * @param bundle the source `Bundle`.
         * @return a new `OfflineDownloadOptions`.
         * @see toBundle
         */
        @JvmStatic
        fun fromBundle(bundle: Bundle) = OfflineDownloadOptions(
            requireNotNull(bundle.getParcelable(EXTRA_DEFINITION)),
            NotificationOptions.fromBundle(requireNotNull(bundle.getBundle(EXTRA_NOTIFICATION_OPTIONS))),
            bundle.getByteArray(EXTRA_METADATA)
        )
    }

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
     * Creates a `Bundle` from this object.
     * @return a new `Bundle`.
     * @see fromBundle
     */
    fun toBundle() = Bundle().apply {
        putParcelable(EXTRA_DEFINITION, definition)
        putBundle(EXTRA_NOTIFICATION_OPTIONS, notificationOptions.toBundle())
        putByteArray(EXTRA_METADATA, metadata)
    }

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