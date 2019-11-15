[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.model](../index.md) / [OfflineDownloadOptions](./index.md)

# OfflineDownloadOptions

`class OfflineDownloadOptions : `[`Parcelable`](https://developer.android.com/reference/android/os/Parcelable.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/model/OfflineDownloadOptions.kt#L20)

This model represents the options for the download managed by
the [OfflineService](../../dev.micheleferretti.mapboxpluginoffline/-offline-service/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Creates a `OfflineDownloadOptions` with the given values, converting [regionName](-init-.md#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions$<init>(com.mapbox.mapboxsdk.offline.OfflineRegionDefinition, dev.micheleferretti.mapboxpluginoffline.model.NotificationOptions, kotlin.String)/regionName) to a `ByteArray` with [OfflineUtils.convertRegionName](../../dev.micheleferretti.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md).`OfflineDownloadOptions(definition: OfflineRegionDefinition, notificationOptions: `[`NotificationOptions`](../-notification-options/index.md)`, regionName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Creates a `OfflineDownloadOptions` with the given values.`OfflineDownloadOptions(definition: OfflineRegionDefinition, notificationOptions: `[`NotificationOptions`](../-notification-options/index.md)`, metadata: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?)` |

### Properties

| Name | Summary |
|---|---|
| [definition](definition.md) | Region definition that will be used in `OfflineManager.createOfflineRegion()`.`val definition: OfflineRegionDefinition` |
| [metadata](metadata.md) | Region metadata that will be used in `OfflineManager.createOfflineRegion()`.`val metadata: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?` |
| [notificationOptions](notification-options.md) | Options that will be used for the notification shown by the [OfflineService](../../dev.micheleferretti.mapboxpluginoffline/-offline-service/index.md).`val notificationOptions: `[`NotificationOptions`](../-notification-options/index.md) |

### Functions

| Name | Summary |
|---|---|
| [getRegionName](get-region-name.md) | Returns the region name converting [metadata](metadata.md) with [OfflineUtils.convertRegionName](../../dev.micheleferretti.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md).`fun getRegionName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [toString](to-string.md) | Returns a `String` representation of this object.`fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
