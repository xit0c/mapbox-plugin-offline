package dev.micheleferretti.mapboxpluginoffline.model

import android.os.Bundle
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition
import dev.micheleferretti.mapboxpluginoffline.utils.OfflineUtils
import dev.micheleferretti.mapboxpluginoffline.utils.convertToString

class OfflineDownloadOptions(
    val definition: OfflineRegionDefinition,
    val notificationOptions: NotificationOptions,
    val metadata: ByteArray?
) {
    companion object {
        private const val EXTRA_DEFINITION = "extra.DEFINITION"
        private const val EXTRA_NOTIFICATION_OPTIONS = "extra.NOTIFICATION_OPTIONS"
        private const val EXTRA_METADATA = "extra.METADATA"

        @JvmStatic
        fun fromBundle(b: Bundle) = OfflineDownloadOptions(
            requireNotNull(b.getParcelable(EXTRA_DEFINITION)),
            NotificationOptions.fromBundle(requireNotNull(b.getBundle(EXTRA_NOTIFICATION_OPTIONS))),
            b.getByteArray(EXTRA_METADATA)
        )
    }

    constructor(
        definition: OfflineRegionDefinition,
        notificationOptions: NotificationOptions,
        regionName: String
    ) : this(definition, notificationOptions, OfflineUtils.convertRegionName(regionName))

    fun toBundle() = Bundle().apply {
        putParcelable(EXTRA_DEFINITION, definition)
        putBundle(EXTRA_NOTIFICATION_OPTIONS, notificationOptions.toBundle())
        putByteArray(EXTRA_METADATA, metadata)
    }

    fun getRegionName() = OfflineUtils.convertRegionName(metadata)

    override fun toString() = "OfflineDownloadOptions(" +
            "definition=${definition.convertToString()}, " +
            "notificationOptions=$notificationOptions, " +
            "metadata=${metadata?.contentToString()}" +
            ")"
}