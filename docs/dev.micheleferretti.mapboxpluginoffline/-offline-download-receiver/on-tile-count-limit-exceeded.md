[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineDownloadReceiver](index.md) / [onTileCountLimitExceeded](./on-tile-count-limit-exceeded.md)

# onTileCountLimitExceeded

`@CallSuper open fun onTileCountLimitExceeded(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, download: `[`OfflineDownload`](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download/index.md)`, limit: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineDownloadReceiver.kt#L247)

Called when a download tile count exceeds `limit`, see `OfflineRegion.OfflineRegionObserver.mapboxTileCountLimitExceeded()`.

### Parameters

`context` - Receiver Context.

`download` - The observed download.

`limit` - Maximum tile count.