[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineService](./index.md)

# OfflineService

`class OfflineService : `[`Service`](https://developer.android.com/reference/android/app/Service.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineService.kt#L27)

This is the core of the plugin. It manages the downloads, shows notifications and dispatches events that
[OfflineDownloadReceiver](../-offline-download-receiver/index.md)s can listen to.

The static methods [startDownload](start-download.md) and [cancelDownload](cancel-download.md), as their names suggest, can be used to
start and cancel a download respectively. While executing these actions, the service shows a notification
to make the user aware of what's going on.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OfflineService()`<br>This is the core of the plugin. It manages the downloads, shows notifications and dispatches events that [OfflineDownloadReceiver](../-offline-download-receiver/index.md)s can listen to. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [cancelDownload](cancel-download.md) | `fun cancelDownload(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, regionId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Cancels an active download and deletes its region. |
| [startDownload](start-download.md) | `fun startDownload(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, offlineDownloadOptions: `[`OfflineDownloadOptions`](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download-options/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Starts a new download with the provided options. |
