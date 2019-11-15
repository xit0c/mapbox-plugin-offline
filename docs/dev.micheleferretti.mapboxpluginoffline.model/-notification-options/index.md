[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.model](../index.md) / [NotificationOptions](./index.md)

# NotificationOptions

`class NotificationOptions : `[`Parcelable`](https://developer.android.com/reference/android/os/Parcelable.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/model/NotificationOptions.kt#L21)

This model represents the options for the notification shown by
the [OfflineService](../../dev.micheleferretti.mapboxpluginoffline/-offline-service/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Creates a `NotificationOptions` with the given values.`NotificationOptions(smallIconRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = android.R.drawable.stat_sys_download, contentTitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "Offline Map", downloadContentText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "Downloading…", cancelContentText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "Deleting…", cancelActionText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "Cancel", requestMapSnapshot: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, returnActivity: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>? = null)` |

### Properties

| Name | Summary |
|---|---|
| [cancelActionText](cancel-action-text.md) | notification action text for download cancellation.`val cancelActionText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [cancelContentText](cancel-content-text.md) | notification content text shown during cancellation.`val cancelContentText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [contentTitle](content-title.md) | notification content title.`val contentTitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [downloadContentText](download-content-text.md) | notification content text shown during download.`val downloadContentText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [requestMapSnapshot](request-map-snapshot.md) | Whether or not to add a map snapshot of the region as the notification large icon.`val requestMapSnapshot: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [returnActivity](return-activity.md) | The activity to start on notification tap.`val returnActivity: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>?` |
| [smallIconRes](small-icon-res.md) | [DrawableRes](https://developer.android.com/reference/androidx/annotation/DrawableRes.html) id of the notification small icon.`val smallIconRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [toString](to-string.md) | Returns a `String` representation of this object.`fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [EXTRA_REGION_ID_FOR_ACTIVITY](-e-x-t-r-a_-r-e-g-i-o-n_-i-d_-f-o-r_-a-c-t-i-v-i-t-y.md) | Key for the `OfflineRegion` id put as an extra of the Intent used to start [returnActivity](return-activity.md).`const val EXTRA_REGION_ID_FOR_ACTIVITY: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
