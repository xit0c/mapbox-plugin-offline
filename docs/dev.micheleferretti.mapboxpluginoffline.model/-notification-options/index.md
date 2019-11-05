[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.model](../index.md) / [NotificationOptions](./index.md)

# NotificationOptions

`class NotificationOptions : `[`Parcelable`](https://developer.android.com/reference/android/os/Parcelable.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/model/NotificationOptions.kt#L21)

This model represents the options for the notification shown by
the [OfflineService](../../dev.micheleferretti.mapboxpluginoffline/-offline-service/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NotificationOptions(smallIconRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = android.R.drawable.stat_sys_download, contentTitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "Offline Map", downloadContentText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "Downloading…", cancelContentText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "Deleting…", cancelActionText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "Cancel", requestMapSnapshot: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, returnActivity: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<*>? = null)`<br>Creates a `NotificationOptions` with the given values. |

### Properties

| Name | Summary |
|---|---|
| [cancelActionText](cancel-action-text.md) | `val cancelActionText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>notification action text for download cancellation. |
| [cancelContentText](cancel-content-text.md) | `val cancelContentText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>notification content text shown during cancellation. |
| [contentTitle](content-title.md) | `val contentTitle: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>notification content title. |
| [downloadContentText](download-content-text.md) | `val downloadContentText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>notification content text shown during download. |
| [requestMapSnapshot](request-map-snapshot.md) | `val requestMapSnapshot: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether or not to add a map snapshot of the region as the notification large icon. |
| [returnActivity](return-activity.md) | `val returnActivity: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<*>?`<br>The activity to start on notification tap. |
| [smallIconRes](small-icon-res.md) | `val smallIconRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>[DrawableRes](https://developer.android.com/reference/androidx/annotation/DrawableRes.html) id of the notification small icon. |

### Functions

| Name | Summary |
|---|---|
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a `String` representation of this object. |

### Companion Object Properties

| Name | Summary |
|---|---|
| [EXTRA_REGION_ID_FOR_ACTIVITY](-e-x-t-r-a_-r-e-g-i-o-n_-i-d_-f-o-r_-a-c-t-i-v-i-t-y.md) | `const val EXTRA_REGION_ID_FOR_ACTIVITY: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Key for the `OfflineRegion` id put as an extra of the Intent used to start [returnActivity](return-activity.md). |
