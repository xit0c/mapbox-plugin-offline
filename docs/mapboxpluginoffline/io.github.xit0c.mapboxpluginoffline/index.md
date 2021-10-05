//[mapboxpluginoffline](../../index.md)/[io.github.xit0c.mapboxpluginoffline](index.md)

# Package io.github.xit0c.mapboxpluginoffline

## Types

| Name | Summary |
|---|---|
| [OfflineDownloadReceiver](-offline-download-receiver/index.md) | [androidJvm]<br>open class [OfflineDownloadReceiver](-offline-download-receiver/index.md) : [BroadcastReceiver](https://developer.android.com/reference/kotlin/android/content/BroadcastReceiver.html)<br>This BroadcastReceiver can be used to intercept [OfflineService](-offline-service/index.md) events and monitor active downloads. |
| [OfflineService](-offline-service/index.md) | [androidJvm]<br>class [OfflineService](-offline-service/index.md) : [Service](https://developer.android.com/reference/kotlin/android/app/Service.html)<br>This is the core of the plugin. It manages the downloads, shows notifications and dispatches events that [OfflineDownloadReceiver](-offline-download-receiver/index.md)s can listen to. |
