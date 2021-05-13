//[mapboxpluginoffline](../../../index.md)/[dev.micheleferretti.mapboxpluginoffline.model](../index.md)/[NotificationOptions](index.md)



# NotificationOptions  
 [androidJvm] class [NotificationOptions](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)()**smallIconRes**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **contentTitle**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **downloadContentText**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **cancelContentText**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **cancelActionText**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **requestMapSnapshot**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **returnActivity**: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)<*>?) : [Parcelable](https://developer.android.com/reference/kotlin/android/os/Parcelable.html)

This model represents the options for the notification shown by the [OfflineService](../../dev.micheleferretti.mapboxpluginoffline/-offline-service/index.md).

   


## Constructors  
  
| | |
|---|---|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/NotificationOptions/#kotlin.Int#kotlin.String#kotlin.String#kotlin.String#kotlin.String#kotlin.Boolean#java.lang.Class[*]?/PointingToDeclaration/"></a>[NotificationOptions](-notification-options.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/NotificationOptions/#kotlin.Int#kotlin.String#kotlin.String#kotlin.String#kotlin.String#kotlin.Boolean#java.lang.Class[*]?/PointingToDeclaration/"></a> [androidJvm] @[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  <br>  <br>fun [NotificationOptions](-notification-options.md)(@[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html)()smallIconRes: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = android.R.drawable.stat_sys_download, contentTitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "Offline Map", downloadContentText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "Downloading…", cancelContentText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "Deleting…", cancelActionText: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = "Cancel", requestMapSnapshot: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, returnActivity: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)<*>? = null)Creates a NotificationOptions with the given values.   <br>|


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions.Companion///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/toString/#/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br>More info  <br>Returns a String representation of this object.  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/cancelActionText/#/PointingToDeclaration/"></a>[cancelActionText](cancel-action-text.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/cancelActionText/#/PointingToDeclaration/"></a> [androidJvm] val [cancelActionText](cancel-action-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)notification action text for download cancellation.   <br>|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/cancelContentText/#/PointingToDeclaration/"></a>[cancelContentText](cancel-content-text.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/cancelContentText/#/PointingToDeclaration/"></a> [androidJvm] val [cancelContentText](cancel-content-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)notification content text shown during cancellation.   <br>|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/contentTitle/#/PointingToDeclaration/"></a>[contentTitle](content-title.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/contentTitle/#/PointingToDeclaration/"></a> [androidJvm] val [contentTitle](content-title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)notification content title.   <br>|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/downloadContentText/#/PointingToDeclaration/"></a>[downloadContentText](download-content-text.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/downloadContentText/#/PointingToDeclaration/"></a> [androidJvm] val [downloadContentText](download-content-text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)notification content text shown during download.   <br>|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/requestMapSnapshot/#/PointingToDeclaration/"></a>[requestMapSnapshot](request-map-snapshot.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/requestMapSnapshot/#/PointingToDeclaration/"></a> [androidJvm] val [requestMapSnapshot](request-map-snapshot.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = trueWhether or not to add a map snapshot of the region as the notification large icon.   <br>|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/returnActivity/#/PointingToDeclaration/"></a>[returnActivity](return-activity.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/returnActivity/#/PointingToDeclaration/"></a> [androidJvm] val [returnActivity](return-activity.md): [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)<*>? = nullThe activity to start on notification tap.   <br>|
| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/smallIconRes/#/PointingToDeclaration/"></a>[smallIconRes](small-icon-res.md)| <a name="dev.micheleferretti.mapboxpluginoffline.model/NotificationOptions/smallIconRes/#/PointingToDeclaration/"></a> [androidJvm] val [smallIconRes](small-icon-res.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)[DrawableRes](https://developer.android.com/reference/kotlin/androidx/annotation/DrawableRes.html) id of the notification small icon.   <br>|

