//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline](../index.md)/[OfflineDownloadReceiver](index.md)/[onTileCountLimitExceeded](on-tile-count-limit-exceeded.md)

# onTileCountLimitExceeded

[androidJvm]\

@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)

open fun [onTileCountLimitExceeded](on-tile-count-limit-exceeded.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), download: [OfflineDownload](../../io.github.xit0c.mapboxpluginoffline.model/-offline-download/index.md), limit: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))

Called when a download tile count exceeds limit, see OfflineRegion.OfflineRegionObserver.mapboxTileCountLimitExceeded().

## Parameters

androidJvm

| | |
|---|---|
| context | Receiver Context. |
| download | The observed download. |
| limit | Maximum tile count. |
