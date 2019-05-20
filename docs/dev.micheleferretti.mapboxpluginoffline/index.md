[mapboxpluginoffline](../index.md) / [dev.micheleferretti.mapboxpluginoffline](./index.md)

## Package dev.micheleferretti.mapboxpluginoffline

### Types

| Name | Summary |
|---|---|
| [OfflineDownloadReceiver](-offline-download-receiver/index.md) | `open class OfflineDownloadReceiver : `[`BroadcastReceiver`](https://developer.android.com/reference/android/content/BroadcastReceiver.html)<br>This `BroadcastReceiver` can be used to intercept [OfflineService](-offline-service/index.md) events and monitor active downloads. |
| [OfflineService](-offline-service/index.md) | `class OfflineService : `[`Service`](https://developer.android.com/reference/android/app/Service.html)<br>This is the core of the plugin. It manages the downloads, shows notifications and dispatches events that [OfflineDownloadReceiver](-offline-download-receiver/index.md)s can listen to. |
