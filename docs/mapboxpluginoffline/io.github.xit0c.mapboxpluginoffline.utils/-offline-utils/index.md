//[mapboxpluginoffline](../../../index.md)/[io.github.xit0c.mapboxpluginoffline.utils](../index.md)/[OfflineUtils](index.md)

# OfflineUtils

[androidJvm]\
object [OfflineUtils](index.md)

This object only purpose is to provide utility methods.

## Functions

| Name | Summary |
|---|---|
| [convertRegionName](convert-region-name.md) | [androidJvm]<br>fun [convertRegionName](convert-region-name.md)(regionName: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Converts regionName to a plain String. Useful to retrieve the name of a region from metadata.<br>[androidJvm]<br>fun [convertRegionName](convert-region-name.md)(regionName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)?<br>Converts regionName to a ByteArray. Useful to store the name of a region as metadata. |
| [getCompletionPercentage](get-completion-percentage.md) | [androidJvm]<br>fun [getCompletionPercentage](get-completion-percentage.md)(completedResourceCount: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), requiredResourceCount: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the resources completion percentage. |
| [getRegionIdFromIntent](get-region-id-from-intent.md) | [androidJvm]<br>fun [getRegionIdFromIntent](get-region-id-from-intent.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?<br>Returns the region id contained in intent.extras, if any. |
