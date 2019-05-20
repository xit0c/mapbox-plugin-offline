[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.model](../index.md) / [NotificationOptions](./index.md)

# NotificationOptions

`class NotificationOptions` [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/model/NotificationOptions.kt#L21)

This model represents the options for the notification shown by
the [OfflineService](../../dev.micheleferretti.mapboxpluginoffline/-offline-service/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NotificationOptions(smallIconRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_SMALL_ICON_RES, contentTitleRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_CONTENT_TITLE_RES, downloadContentTextRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_DOWNLOAD_CONTENT_TEXT_RES, cancelContentTextRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_CANCEL_CONTENT_TEXT_RES, cancelActionTextRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_CANCEL_ACTION_TEXT_RES, requestMapSnapshot: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = DEFAULT_REQUEST_MAP_SNAPSHOT, returnActivity: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<*>? = DEFAULT_RETURN_ACTIVITY)`<br>Creates a `NotificationOptions` with the given values. |

### Properties

| Name | Summary |
|---|---|
| [cancelActionTextRes](cancel-action-text-res.md) | `val cancelActionTextRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>[StringRes](https://developer.android.com/reference/androidx/annotation/StringRes.html) id of the notification action text for download cancellation. |
| [cancelContentTextRes](cancel-content-text-res.md) | `val cancelContentTextRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>[StringRes](https://developer.android.com/reference/androidx/annotation/StringRes.html) id of the notification content text, shown during cancellation. |
| [contentTitleRes](content-title-res.md) | `val contentTitleRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>[StringRes](https://developer.android.com/reference/androidx/annotation/StringRes.html) id of the notification content title. |
| [downloadContentTextRes](download-content-text-res.md) | `val downloadContentTextRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>[StringRes](https://developer.android.com/reference/androidx/annotation/StringRes.html) id of the notification content text, shown during download. |
| [requestMapSnapshot](request-map-snapshot.md) | `val requestMapSnapshot: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether or not to add a map snapshot of the region as the notification large icon. |
| [returnActivity](return-activity.md) | `val returnActivity: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<*>?`<br>The activity to start on notification tap. |
| [smallIconRes](small-icon-res.md) | `val smallIconRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>[DrawableRes](https://developer.android.com/reference/androidx/annotation/DrawableRes.html) id of the notification small icon. |

### Functions

| Name | Summary |
|---|---|
| [toBundle](to-bundle.md) | `fun toBundle(): `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)<br>Creates a `Bundle` from this object. |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a `String` representation of this object. |

### Companion Object Properties

| Name | Summary |
|---|---|
| [EXTRA_REGION_ID_FOR_ACTIVITY](-e-x-t-r-a_-r-e-g-i-o-n_-i-d_-f-o-r_-a-c-t-i-v-i-t-y.md) | `const val EXTRA_REGION_ID_FOR_ACTIVITY: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Key for the `OfflineRegion` id put as an extra of the Intent used to start [returnActivity](return-activity.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [fromBundle](from-bundle.md) | `fun fromBundle(bundle: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`): `[`NotificationOptions`](./index.md)<br>Creates a `NotificationOptions` from a `Bundle`. |
