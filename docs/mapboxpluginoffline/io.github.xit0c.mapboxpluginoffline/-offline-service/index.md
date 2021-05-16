//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline](../index.md)/[OfflineService](index.md)



# OfflineService  
 [androidJvm] class [OfflineService](index.md) : [Service](https://developer.android.com/reference/kotlin/android/app/Service.html)

This is the core of the plugin. It manages the downloads, shows notifications and dispatches events that [OfflineDownloadReceiver](../-offline-download-receiver/index.md)s can listen to.



The static methods [startDownload](-companion/start-download.md) and [cancelDownload](-companion/cancel-download.md), as their names suggest, can be used to start and cancel a download respectively. While executing these actions, the service shows a notification to make the user aware of what's going on.

   


## Constructors  
  
| | |
|---|---|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineService/OfflineService/#/PointingToDeclaration/"></a>[OfflineService](-offline-service.md)| <a name="io.github.xit0c.mapboxpluginoffline/OfflineService/OfflineService/#/PointingToDeclaration/"></a> [androidJvm] fun [OfflineService](-offline-service.md)()   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="io.github.xit0c.mapboxpluginoffline/OfflineService.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="io.github.xit0c.mapboxpluginoffline/OfflineService.Companion///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|

