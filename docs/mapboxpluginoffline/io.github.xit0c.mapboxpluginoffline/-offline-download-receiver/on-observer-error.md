//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline](../index.md)/[OfflineDownloadReceiver](index.md)/[onObserverError](on-observer-error.md)



# onObserverError  
[androidJvm]  
Content  
@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)()  
  
open fun [onObserverError](on-observer-error.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), download: [OfflineDownload](../../io.github.xit0c.mapboxpluginoffline.model/-offline-download/index.md), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)  
More info  


Called when a download observer fails, see OfflineRegion.OfflineRegionObserver.onError().



## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onObserverError/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.String?#kotlin.String?/PointingToDeclaration/"></a>context| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onObserverError/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.String?#kotlin.String?/PointingToDeclaration/"></a><br><br>Receiver Context.<br><br>|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onObserverError/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.String?#kotlin.String?/PointingToDeclaration/"></a>download| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onObserverError/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.String?#kotlin.String?/PointingToDeclaration/"></a><br><br>The observed download.<br><br>|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onObserverError/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.String?#kotlin.String?/PointingToDeclaration/"></a>reason| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onObserverError/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.String?#kotlin.String?/PointingToDeclaration/"></a><br><br>Error reason (see OfflineRegionError.getReason()).<br><br>|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onObserverError/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.String?#kotlin.String?/PointingToDeclaration/"></a>message| <a name="io.github.xit0c.mapboxpluginoffline/OfflineDownloadReceiver/onObserverError/#android.content.Context#io.github.xit0c.mapboxpluginoffline.model.OfflineDownload#kotlin.String?#kotlin.String?/PointingToDeclaration/"></a><br><br>Error message (see OfflineRegionError.getMessage()).<br><br>|
  
  



