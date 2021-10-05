//[mapboxpluginoffline](../../index.md)/[io.github.xit0c.mapboxpluginoffline.utils](index.md)

# Package io.github.xit0c.mapboxpluginoffline.utils

## Types

| Name | Summary |
|---|---|
| [OfflineUtils](-offline-utils/index.md) | [androidJvm]<br>object [OfflineUtils](-offline-utils/index.md)<br>This object only purpose is to provide utility methods. |

## Functions

| Name | Summary |
|---|---|
| [convertToString](convert-to-string.md) | [androidJvm]<br>fun OfflineRegion.[convertToString](convert-to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>fun OfflineRegionDefinition.[convertToString](convert-to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a String representation of this object. |
| [getCameraPosition](get-camera-position.md) | [androidJvm]<br>fun OfflineRegionDefinition.[getCameraPosition](get-camera-position.md)(): CameraPosition<br>Returns a CameraPosition built with this definition data. |
| [getCompletionPercentage](get-completion-percentage.md) | [androidJvm]<br>fun OfflineRegionStatus.[getCompletionPercentage](get-completion-percentage.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the OfflineRegionStatus resources completion percentage. |
| [getName](get-name.md) | [androidJvm]<br>fun OfflineRegion.[getName](get-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Returns the region name converting metadata with [OfflineUtils.convertRegionName](-offline-utils/convert-region-name.md). |
| [requireLong](require-long.md) | [androidJvm]<br>fun [Bundle](https://developer.android.com/reference/kotlin/android/os/Bundle.html).[requireLong](require-long.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns the value associated with the given key, if exists and is of the desired type. Otherwise throws. |
