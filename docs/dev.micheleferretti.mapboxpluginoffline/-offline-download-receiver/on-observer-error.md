[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineDownloadReceiver](index.md) / [onObserverError](./on-observer-error.md)

# onObserverError

`@CallSuper open fun onObserverError(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, download: `[`OfflineDownload`](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download/index.md)`, reason: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineDownloadReceiver.kt#L236)

Called when a download observer fails, see `OfflineRegion.OfflineRegionObserver.onError()`.

### Parameters

`context` - Receiver Context.

`download` - The observed download.

`reason` - Error reason (see `OfflineRegionError.getReason()`).

`message` - Error message (see `OfflineRegionError.getMessage()`).