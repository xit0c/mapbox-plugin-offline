[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineDownloadReceiver](index.md) / [onCreateError](./on-create-error.md)

# onCreateError

`open fun onCreateError(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, options: `[`OfflineDownloadOptions`](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download-options/index.md)`, error: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineDownloadReceiver.kt#L190)

Called when a download creation fails, see `OfflineManager.CreateOfflineRegionCallback.onError()`.

### Parameters

`context` - Receiver Context.

`options` - The options used to create the download.

`error` - Error message.