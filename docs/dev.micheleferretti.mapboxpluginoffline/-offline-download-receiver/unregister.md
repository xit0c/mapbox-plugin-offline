[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineDownloadReceiver](index.md) / [unregister](./unregister.md)

# unregister

`@CallSuper open fun unregister(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineDownloadReceiver.kt#L141)

Unregisters this receiver and clears the internal list returned by [getActiveDownloads](get-active-downloads.md).

### Parameters

`context` - Context used to get the `LocalBroadcastManager` instance.