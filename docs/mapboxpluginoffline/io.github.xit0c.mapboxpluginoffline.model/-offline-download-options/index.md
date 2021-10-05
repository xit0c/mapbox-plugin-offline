//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline.model](../index.md)/[OfflineDownloadOptions](index.md)

# OfflineDownloadOptions

[androidJvm]\
class [OfflineDownloadOptions](index.md)(definition: OfflineRegionDefinition, notificationOptions: [NotificationOptions](../-notification-options/index.md), metadata: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?) : [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)

This model represents the options for the download managed by the [OfflineService](../../io.github.xit0c.mapboxpluginoffline/-offline-service/index.md).

## Constructors

| | |
|---|---|
| [OfflineDownloadOptions](-offline-download-options.md) | [androidJvm]<br>fun [OfflineDownloadOptions](-offline-download-options.md)(definition: OfflineRegionDefinition, notificationOptions: [NotificationOptions](../-notification-options/index.md), regionName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Creates a OfflineDownloadOptions with the given values, converting regionName to a ByteArray with [OfflineUtils.convertRegionName](../../io.github.xit0c.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md). |
| [OfflineDownloadOptions](-offline-download-options.md) | [androidJvm]<br>fun [OfflineDownloadOptions](-offline-download-options.md)(definition: OfflineRegionDefinition, notificationOptions: [NotificationOptions](../-notification-options/index.md), metadata: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?)<br>Creates a OfflineDownloadOptions with the given values. |

## Functions

| Name | Summary |
|---|---|
| [getRegionName](get-region-name.md) | [androidJvm]<br>fun [getRegionName](get-region-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Returns the region name converting [metadata](metadata.md) with [OfflineUtils.convertRegionName](../../io.github.xit0c.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md). |
| [toString](to-string.md) | [androidJvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a String representation of this object. |

## Properties

| Name | Summary |
|---|---|
| [definition](definition.md) | [androidJvm]<br>val [definition](definition.md): OfflineRegionDefinition<br>Region definition that will be used in OfflineManager.createOfflineRegion(). |
| [metadata](metadata.md) | [androidJvm]<br>val [metadata](metadata.md): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?<br>Region metadata that will be used in OfflineManager.createOfflineRegion(). |
| [notificationOptions](notification-options.md) | [androidJvm]<br>val [notificationOptions](notification-options.md): [NotificationOptions](../-notification-options/index.md)<br>Options that will be used for the notification shown by the [OfflineService](../../io.github.xit0c.mapboxpluginoffline/-offline-service/index.md). |
