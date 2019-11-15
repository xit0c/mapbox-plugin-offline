[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.utils](../index.md) / [OfflineUtils](./index.md)

# OfflineUtils

`object OfflineUtils` [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/utils/OfflineUtils.kt#L12)

This object only purpose is to provide utility methods.

### Functions

| Name | Summary |
|---|---|
| [convertRegionName](convert-region-name.md) | Converts `regionName` to a `ByteArray`. Useful to store the name of a region as metadata.`fun convertRegionName(regionName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?`<br>Converts `regionName` to a plain `String`. Useful to retrieve the name of a region from metadata.`fun convertRegionName(regionName: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [getRegionIdFromIntent](get-region-id-from-intent.md) | Returns the region id contained in `intent.extras`, if any.`fun getRegionIdFromIntent(intent: `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?` |
