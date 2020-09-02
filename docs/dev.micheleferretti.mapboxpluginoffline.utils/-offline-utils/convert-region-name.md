[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.utils](../index.md) / [OfflineUtils](index.md) / [convertRegionName](./convert-region-name.md)

# convertRegionName

`fun convertRegionName(regionName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?` [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/utils/OfflineUtils.kt#L25)

Converts `regionName` to a `ByteArray`. Useful to store the name of a region as metadata.

**Return**
the region name converted to a `ByteArray`.

**See Also**

[OfflineDownloadOptions.metadata](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download-options/metadata.md)

[OfflineDownloadOptions.getRegionName](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download-options/get-region-name.md)

`fun convertRegionName(regionName: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/utils/OfflineUtils.kt#L38)

Converts `regionName` to a plain `String`. Useful to retrieve the name of a region from metadata.

**Return**
the region name converted to a `String`.

**See Also**

[OfflineDownloadOptions.metadata](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download-options/metadata.md)

[OfflineDownloadOptions.getRegionName](../../dev.micheleferretti.mapboxpluginoffline.model/-offline-download-options/get-region-name.md)

