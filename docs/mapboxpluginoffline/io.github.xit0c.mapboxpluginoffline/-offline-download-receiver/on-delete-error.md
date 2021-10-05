//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline](../index.md)/[OfflineDownloadReceiver](index.md)/[onDeleteError](on-delete-error.md)

# onDeleteError

[androidJvm]\

@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)

open fun [onDeleteError](on-delete-error.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), download: [OfflineDownload](../../io.github.xit0c.mapboxpluginoffline.model/-offline-download/index.md), error: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

Called when a download is canceled but the region deletion fails, see OfflineRegion.OfflineRegionDeleteCallback.onError().

## Parameters

androidJvm

| | |
|---|---|
| context | Receiver Context. |
| download | The canceled but not deleted download. |
| error | Error message. |
