//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline.model](../index.md)/[OfflineDownloadOptions](index.md)



# OfflineDownloadOptions  
 [androidJvm] class [OfflineDownloadOptions](index.md)(**definition**: OfflineRegionDefinition, **notificationOptions**: [NotificationOptions](../-notification-options/index.md), **metadata**: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?) : [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)

This model represents the options for the download managed by the [OfflineService](../../io.github.xit0c.mapboxpluginoffline/-offline-service/index.md).

   


## Constructors  
  
| | |
|---|---|
| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/OfflineDownloadOptions/#com.mapbox.mapboxsdk.offline.OfflineRegionDefinition#io.github.xit0c.mapboxpluginoffline.model.NotificationOptions#kotlin.String/PointingToDeclaration/"></a>[OfflineDownloadOptions](-offline-download-options.md)| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/OfflineDownloadOptions/#com.mapbox.mapboxsdk.offline.OfflineRegionDefinition#io.github.xit0c.mapboxpluginoffline.model.NotificationOptions#kotlin.String/PointingToDeclaration/"></a> [androidJvm] fun [OfflineDownloadOptions](-offline-download-options.md)(definition: OfflineRegionDefinition, notificationOptions: [NotificationOptions](../-notification-options/index.md), regionName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))Creates a OfflineDownloadOptions with the given values, converting regionName to a ByteArray with [OfflineUtils.convertRegionName](../../io.github.xit0c.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md).   <br>|
| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/OfflineDownloadOptions/#com.mapbox.mapboxsdk.offline.OfflineRegionDefinition#io.github.xit0c.mapboxpluginoffline.model.NotificationOptions#kotlin.ByteArray?/PointingToDeclaration/"></a>[OfflineDownloadOptions](-offline-download-options.md)| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/OfflineDownloadOptions/#com.mapbox.mapboxsdk.offline.OfflineRegionDefinition#io.github.xit0c.mapboxpluginoffline.model.NotificationOptions#kotlin.ByteArray?/PointingToDeclaration/"></a> [androidJvm] fun [OfflineDownloadOptions](-offline-download-options.md)(definition: OfflineRegionDefinition, notificationOptions: [NotificationOptions](../-notification-options/index.md), metadata: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?)Creates a OfflineDownloadOptions with the given values.   <br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/getRegionName/#/PointingToDeclaration/"></a>[getRegionName](get-region-name.md)| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/getRegionName/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>fun [getRegionName](get-region-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?  <br>More info  <br>Returns the region name converting [metadata](metadata.md) with [OfflineUtils.convertRegionName](../../io.github.xit0c.mapboxpluginoffline.utils/-offline-utils/convert-region-name.md).  <br><br><br>|
| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br>More info  <br>Returns a String representation of this object.  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/definition/#/PointingToDeclaration/"></a>[definition](definition.md)| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/definition/#/PointingToDeclaration/"></a> [androidJvm] val [definition](definition.md): OfflineRegionDefinitionRegion definition that will be used in OfflineManager.createOfflineRegion().   <br>|
| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/metadata/#/PointingToDeclaration/"></a>[metadata](metadata.md)| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/metadata/#/PointingToDeclaration/"></a> [androidJvm] val [metadata](metadata.md): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?Region metadata that will be used in OfflineManager.createOfflineRegion().   <br>|
| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/notificationOptions/#/PointingToDeclaration/"></a>[notificationOptions](notification-options.md)| <a name="io.github.xit0c.mapboxpluginoffline.model/OfflineDownloadOptions/notificationOptions/#/PointingToDeclaration/"></a> [androidJvm] val [notificationOptions](notification-options.md): [NotificationOptions](../-notification-options/index.md)Options that will be used for the notification shown by the [OfflineService](../../io.github.xit0c.mapboxpluginoffline/-offline-service/index.md).   <br>|

