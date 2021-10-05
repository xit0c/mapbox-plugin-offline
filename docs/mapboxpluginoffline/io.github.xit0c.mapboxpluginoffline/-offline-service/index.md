//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline](../index.md)/[OfflineService](index.md)

# OfflineService

[androidJvm]\
class [OfflineService](index.md) : [Service](https://developer.android.com/reference/kotlin/android/app/Service.html)

This is the core of the plugin. It manages the downloads, shows notifications and dispatches events that [OfflineDownloadReceiver](../-offline-download-receiver/index.md)s can listen to.

The static methods [startDownload](-companion/start-download.md) and [cancelDownload](-companion/cancel-download.md), as their names suggest, can be used to start and cancel a download respectively. While executing these actions, the service shows a notification to make the user aware of what's going on.

## Constructors

| | |
|---|---|
| [OfflineService](-offline-service.md) | [androidJvm]<br>fun [OfflineService](-offline-service.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
