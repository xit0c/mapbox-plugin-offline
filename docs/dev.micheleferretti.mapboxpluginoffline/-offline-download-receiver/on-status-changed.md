[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineDownloadReceiver](index.md) / [onStatusChanged](./on-status-changed.md)

# onStatusChanged

`@CallSuper open fun onStatusChanged(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, download: `[`OfflineDownload`](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineDownloadReceiver.kt#L224)

Called when a download changes its status, see `OfflineRegion.OfflineRegionObserver.onStatusChanged()`.

### Parameters

`context` - Receiver Context.

`download` - The observed download.