[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineService](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`OfflineService()`

This is the core of the plugin. It manages the downloads, shows notifications and dispatches events that
[OfflineDownloadReceiver](../-offline-download-receiver/index.md)s can listen to.

The static methods [startDownload](start-download.md) and [cancelDownload](cancel-download.md), as their names suggest, can be used to
start and cancel a download respectively. While executing these actions, the service shows a notification
to make the user aware of what's going on.

