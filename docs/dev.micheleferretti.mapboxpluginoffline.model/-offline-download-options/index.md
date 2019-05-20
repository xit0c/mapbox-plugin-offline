[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.model](../index.md) / [OfflineDownloadOptions](./index.md)

# OfflineDownloadOptions

`class OfflineDownloadOptions` [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/model/OfflineDownloadOptions.kt#L18)

This model represents the options for the download managed by
the [OfflineService](../../dev.micheleferretti.mapboxpluginoffline/-offline-service/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OfflineDownloadOptions(definition: OfflineRegionDefinition, notificationOptions: `[`NotificationOptions`](../-notification-options/index.md)`, regionName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Creates a `OfflineDownloadOptions` with the given values, converting [regionName](-init-.md#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownloadOptions$<init>(com.mapbox.mapboxsdk.offline.OfflineRegionDefinition, dev.micheleferretti.mapboxpluginoffline.model.NotificationOptions, kotlin.String)/regionName) to a `ByteArray` with [OfflineUtils.convertRegionName](../../dev.micheleferretti.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md).`OfflineDownloadOptions(definition: OfflineRegionDefinition, notificationOptions: `[`NotificationOptions`](../-notification-options/index.md)`, metadata: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?)`<br>Creates a `OfflineDownloadOptions` with the given values. |

### Properties

| Name | Summary |
|---|---|
| [definition](definition.md) | `val definition: OfflineRegionDefinition`<br>Region definition that will be used in `OfflineManager.createOfflineRegion()`. |
| [metadata](metadata.md) | `val metadata: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?`<br>Region metadata that will be used in `OfflineManager.createOfflineRegion()`. |
| [notificationOptions](notification-options.md) | `val notificationOptions: `[`NotificationOptions`](../-notification-options/index.md)<br>Options that will be used for the notification shown by the [OfflineService](../../dev.micheleferretti.mapboxpluginoffline/-offline-service/index.md). |

### Functions

| Name | Summary |
|---|---|
| [getRegionName](get-region-name.md) | `fun getRegionName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Returns the region name converting [metadata](metadata.md) with [OfflineUtils.convertRegionName](../../dev.micheleferretti.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md). |
| [toBundle](to-bundle.md) | `fun toBundle(): `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)<br>Creates a `Bundle` from this object. |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a `String` representation of this object. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [fromBundle](from-bundle.md) | `fun fromBundle(bundle: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`): `[`OfflineDownloadOptions`](./index.md)<br>Creates a `OfflineDownloadOptions` from a `Bundle`. |
