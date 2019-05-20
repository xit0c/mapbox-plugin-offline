[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.model](../index.md) / [OfflineDownloadOptions](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`OfflineDownloadOptions(definition: OfflineRegionDefinition, notificationOptions: `[`NotificationOptions`](../-notification-options/index.md)`, regionName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`

Creates a `OfflineDownloadOptions` with the given values,
converting [regionName](-init-.md#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions$<init>(com.mapbox.mapboxsdk.offline.OfflineRegionDefinition, dev.micheleferretti.mapboxpluginoffline.model.NotificationOptions, kotlin.String)/regionName) to a `ByteArray` with [OfflineUtils.convertRegionName](../../dev.micheleferretti.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md).

`OfflineDownloadOptions(definition: OfflineRegionDefinition, notificationOptions: `[`NotificationOptions`](../-notification-options/index.md)`, metadata: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?)`

Creates a `OfflineDownloadOptions` with the given values.

**Constructor**
Creates a `OfflineDownloadOptions` with the given values.

