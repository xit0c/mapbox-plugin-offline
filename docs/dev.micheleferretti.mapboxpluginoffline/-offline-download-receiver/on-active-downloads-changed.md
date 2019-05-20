[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline](../index.md) / [OfflineDownloadReceiver](index.md) / [onActiveDownloadsChanged](./on-active-downloads-changed.md)

# onActiveDownloadsChanged

`open fun onActiveDownloadsChanged(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, activeDownloads: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, `[`OfflineDownload`](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/OfflineDownloadReceiver.kt#L249)

Called when `activeDownloads` map changes. Override this to respond to generic changes.

### Parameters

`context` - Receiver Context.

`activeDownloads` - The active downloads map.

**See Also**

[getActiveDownloads](get-active-downloads.md)

