//[mapboxpluginoffline](../../../index.md)/[dev.micheleferretti.mapboxpluginoffline](../index.md)/[OfflineDownloadReceiver](index.md)/[onTileCountLimitExceeded](on-tile-count-limit-exceeded.md)



# onTileCountLimitExceeded  
[androidJvm]  
Content  
@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)()  
  
open fun [onTileCountLimitExceeded](on-tile-count-limit-exceeded.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), download: [OfflineDownload](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download/index.md), limit: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))  
More info  


Called when a download tile count exceeds limit, see OfflineRegion.OfflineRegionObserver.mapboxTileCountLimitExceeded().



## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a>context| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a><br><br>Receiver Context.<br><br>|
| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a>download| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a><br><br>The observed download.<br><br>|
| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a>limit| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onTileCountLimitExceeded/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.Long/PointingToDeclaration/"></a><br><br>Maximum tile count.<br><br>|
  
  



