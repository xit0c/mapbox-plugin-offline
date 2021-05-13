//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline](../index.md)/[OfflineDownloadReceiver](index.md)/[onTileCountLimitExceeded](on-tile-count-limit-exceeded.md)



# onTileCountLimitExceeded  
[androidJvm]  
Content  
@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)()  
  
open fun [onTileCountLimitExceeded](on-tile-count-limit-exceeded.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), download: [OfflineDownload](../../io.github.xit0c.mapboxpluginoffline.model/-offline-download/index.md), limit: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))  
More info  


Called when a download tile count exceeds limit, see OfflineRegion.OfflineRegionObserver.mapboxTileCountLimitExceeded().



## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a>context| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a><br><br>Receiver Context.<br><br>|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a>download| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a><br><br>The observed download.<br><br>|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a>limit| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a><br><br>Maximum tile count.<br><br>|
  
  



