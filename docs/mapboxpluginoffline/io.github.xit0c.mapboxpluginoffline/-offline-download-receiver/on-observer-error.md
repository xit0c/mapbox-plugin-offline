//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline](../index.md)/[OfflineDownloadReceiver](index.md)/[onObserverError](on-observer-error.md)

# onObserverError

[androidJvm]\

@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)

open fun [onObserverError](on-observer-error.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), download: [OfflineDownload](../../io.github.xit0c.mapboxpluginoffline.model/-offline-download/index.md), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

Called when a download observer fails, see OfflineRegion.OfflineRegionObserver.onError().

## Parameters

androidJvm

| | |
|---|---|
| context | Receiver Context. |
| download | The observed download. |
| reason | Error reason (see OfflineRegionError.getReason()). |
| message | Error message (see OfflineRegionError.getMessage()). |
