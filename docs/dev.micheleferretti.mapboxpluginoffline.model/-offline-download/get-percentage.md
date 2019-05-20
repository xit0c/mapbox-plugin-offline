[mapboxpluginoffline](../../index.md) / [dev.micheleferretti.mapboxpluginoffline.model](../index.md) / [OfflineDownload](index.md) / [getPercentage](./get-percentage.md)

# getPercentage

`fun getPercentage(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/model/OfflineDownload.kt#L105)

Returns the download completion percentage.

**Return**
the download completion percentage.

`@JvmStatic fun getPercentage(completedResourceCount: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, requiredResourceCount: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) [(source)](https://github.com/xit0c/mapbox-plugin-offline/tree/master/mapboxpluginoffline/src/main/java/dev/micheleferretti/mapboxpluginoffline/model/OfflineDownload.kt#L60)

Returns the completion percentage.

### Parameters

`completedResourceCount` - number of resources that have been fully download.

`requiredResourceCount` - number of resources that are known to be required.

**Return**
the completion percentage.

