//[mapboxpluginoffline](../../../index.md)/[dev.micheleferretti.mapboxpluginoffline](../index.md)/[OfflineDownloadReceiver](index.md)/[onDeleteError](on-delete-error.md)



# onDeleteError  
[androidJvm]  
Content  
@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)()  
  
open fun [onDeleteError](on-delete-error.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), download: [OfflineDownload](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download/index.md), error: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)  
More info  


Called when a download is canceled but the region deletion fails, see OfflineRegion.OfflineRegionDeleteCallback.onError().



## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onDeleteError/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.String?/PointingToDeclaration/"></a>context| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onDeleteError/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.String?/PointingToDeclaration/"></a><br><br>Receiver Context.<br><br>|
| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onDeleteError/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.String?/PointingToDeclaration/"></a>download| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onDeleteError/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.String?/PointingToDeclaration/"></a><br><br>The canceled but not deleted download.<br><br>|
| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onDeleteError/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.String?/PointingToDeclaration/"></a>error| <a name="dev.micheleferretti.mapboxpluginoffline/OfflineDownloadReceiver/onDeleteError/#android.content.Context#dev.micheleferretti.mapboxpluginoffline.model.OfflineDownload#kotlin.String?/PointingToDeclaration/"></a><br><br>Error message.<br><br>|
  
  



