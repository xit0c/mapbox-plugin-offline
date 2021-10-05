//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline.model](../index.md)/[NotificationOptions](index.md)

# NotificationOptions

[androidJvm]\
class [NotificationOptions](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)smallIconRes: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), contentTitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), downloadContentText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cancelContentText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cancelActionText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), requestMapSnapshot: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), returnActivity: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;*&gt;?) : [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)

This model represents the options for the notification shown by the [OfflineService](../../io.github.xit0c.mapboxpluginoffline/-offline-service/index.md).

## Constructors

| | |
|---|---|
| [NotificationOptions](-notification-options.md) | [androidJvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [NotificationOptions](-notification-options.md)(@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)smallIconRes: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = android.R.drawable.stat_sys_download, contentTitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "Offline Map", downloadContentText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "Downloading…", cancelContentText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "Deleting…", cancelActionText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "Cancel", requestMapSnapshot: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, returnActivity: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;*&gt;? = null)<br>Creates a NotificationOptions with the given values. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [toString](to-string.md) | [androidJvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a String representation of this object. |

## Properties

| Name | Summary |
|---|---|
| [cancelActionText](cancel-action-text.md) | [androidJvm]<br>val [cancelActionText](cancel-action-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>notification action text for download cancellation. |
| [cancelContentText](cancel-content-text.md) | [androidJvm]<br>val [cancelContentText](cancel-content-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>notification content text shown during cancellation. |
| [contentTitle](content-title.md) | [androidJvm]<br>val [contentTitle](content-title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>notification content title. |
| [downloadContentText](download-content-text.md) | [androidJvm]<br>val [downloadContentText](download-content-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>notification content text shown during download. |
| [requestMapSnapshot](request-map-snapshot.md) | [androidJvm]<br>val [requestMapSnapshot](request-map-snapshot.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true<br>Whether or not to add a map snapshot of the region as the notification large icon. |
| [returnActivity](return-activity.md) | [androidJvm]<br>val [returnActivity](return-activity.md): [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;*&gt;? = null<br>The activity to start on notification tap. |
| [smallIconRes](small-icon-res.md) | [androidJvm]<br>val [smallIconRes](small-icon-res.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html) id of the notification small icon. |
