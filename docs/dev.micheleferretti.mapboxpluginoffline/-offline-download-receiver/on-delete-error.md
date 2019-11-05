[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineDownloadReceiver](index.md) / [onDeleteError](./on-delete-error.md)

# onDeleteError

`@CallSuper open fun onDeleteError(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, download: `[`OfflineDownload`](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download/index.md)`, error: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineDownloadReceiver.kt#L211)

Called when a download is canceled but the region deletion fails, see `OfflineRegion.OfflineRegionDeleteCallback.onError()`.

### Parameters

`context` - Receiver Context.

`download` - The canceled but not deleted download.

`error` - Error message.