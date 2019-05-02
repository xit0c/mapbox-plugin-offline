package dev.micheleferretti.mapboxpluginoffline.model

import android.os.Bundle
import dev.micheleferretti.mapboxpluginoffline.utils.requireBoolean
import dev.micheleferretti.mapboxpluginoffline.utils.requireLong

class OfflineDownload(
    val regionId: Long,
    val options: OfflineDownloadOptions,
    val completedResourceCount: Long,
    val requiredResourceCount: Long,
    val completedResourceSize: Long,
    val isActive: Boolean
) {
    companion object {
        private const val EXTRA_REGION_ID = "extra.REGION_ID"
        private const val EXTRA_OPTIONS = "extra.OPTIONS"
        private const val EXTRA_COMPLETED_RESOURCE_COUNT = "extra.COMPLETED_RESOURCE_COUNT"
        private const val EXTRA_REQUIRED_RESOURCE_COUNT = "extra.REQUIRED_RESOURCE_COUNT"
        private const val EXTRA_COMPLETED_RESOURCE_SIZE = "extra.COMPLETED_RESOURCE_SIZE"
        private const val EXTRA_IS_ACTIVE = "extra.IS_ACTIVE"

        @JvmStatic
        fun fromBundle(b: Bundle) = OfflineDownload(
            b.requireLong(EXTRA_REGION_ID),
            OfflineDownloadOptions.fromBundle(requireNotNull(b.getBundle(EXTRA_OPTIONS))),
            b.requireLong(EXTRA_COMPLETED_RESOURCE_COUNT),
            b.requireLong(EXTRA_REQUIRED_RESOURCE_COUNT),
            b.requireLong(EXTRA_COMPLETED_RESOURCE_SIZE),
            b.requireBoolean(EXTRA_IS_ACTIVE)
        )

        @JvmStatic
        fun getPercentage(completedResourceCount: Long, requiredResourceCount: Long) =
            (if (requiredResourceCount > 0) 100.0 * completedResourceCount / requiredResourceCount else 0.0).toInt()
    }

    constructor(id: Long, options: OfflineDownloadOptions): this(id, options, 0L, 0L, 0L, false)

    fun toBundle() = Bundle().apply {
        putLong(EXTRA_REGION_ID, regionId)
        putBundle(EXTRA_OPTIONS, options.toBundle())
        putLong(EXTRA_COMPLETED_RESOURCE_COUNT, completedResourceCount)
        putLong(EXTRA_REQUIRED_RESOURCE_COUNT, requiredResourceCount)
        putLong(EXTRA_COMPLETED_RESOURCE_SIZE, completedResourceSize)
        putBoolean(EXTRA_IS_ACTIVE, isActive)
    }

    fun getPercentage() = getPercentage(completedResourceCount, requiredResourceCount)

    fun isComplete() = (completedResourceCount == requiredResourceCount) && !isActive

    override fun toString() = "OfflineDownload(" +
            "regionId=$regionId, " +
            "options=$options, " +
            "completedResourceCount=$completedResourceCount, " +
            "requiredResourceCount=$requiredResourceCount, " +
            "completedResourceSize=$completedResourceSize, " +
            "isActive=$isActive" +
            ")"
}