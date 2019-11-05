[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineDownloadReceiver](index.md) / [onCreate](./on-create.md)

# onCreate

`@CallSuper open fun onCreate(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, download: `[`OfflineDownload`](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineDownloadReceiver.kt#L180)

Called when a download is created, see `OfflineManager.CreateOfflineRegionCallback.onCreate()`.

### Parameters

`context` - Receiver Context.

`download` - The created download.