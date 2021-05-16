# mapbox-plugin-offline
An alternative to [Mapbox offline plugin](https://github.com/mapbox/mapbox-plugins-android/tree/master/plugin-offline) for Android, written in [Kotlin](https://kotlinlang.org).
Generated docs available [here](https://xit0c.github.io/mapbox-plugin-offline).

## Getting Started

This plugin is published to [Maven Central](https://search.maven.org/artifact/io.github.xit0c/mapbox-plugin-offline).
Include it in your `build.gradle` file with
```gradle
implementation 'io.github.xit0c:mapbox-plugin-offline:3.0.0'
```

Note: older versions (`<= 2.2.3`) were published to Bintray's JCenter before its
[shutdown](https://jfrog.com/blog/into-the-sunset-bintray-jcenter-gocenter-and-chartcenter) as
```gradle
implementation 'dev.micheleferretti:mapbox-plugin-offline:2.2.3'
```

## Usage

`OfflineService` is the core of this plugin. It manages the downloads, shows notifications and dispatches events that `OfflineDownloadReceiver`(s) can listen to.

Its static methods `OfflineService.startDownload()` and `OfflineService.cancelDownload()`, as their names suggest, can be used to start and cancel a download respectively. While executing these actions, the service shows a notification to make the user aware of what's going on.

### Start a download

Create a `NotificationOptions`: the options you provide will be used to build `OfflineService`'s notifications.
```kotlin
val notificationOptions = NotificationOptions(
    R.drawable.small_icon, // @DrawableRes for notification's small icon
    contentTitle, // notification's content title
    downloadContentText, // notification's content text shown during download
    cancelContentText, // notification's content text shown during cancellation
    cancelActionText, // notification's cancel action text
    true, // whether or not to add a map snapshot of the region as notification's large icon
    MyReturnActivity::class.java // Activity to start on notification tap (can be null)
)
```

Then, together with an [OfflineRegionDefinition](https://docs.mapbox.com/android/maps/overview/offline/#defining-a-region) and an optional [metadata](https://docs.mapbox.com/android/maps/overview/offline/#metadata) `ByteArray`, use it to create an `OfflineDownloadOptions`

```kotlin
val offlineDownloadOptions = OfflineDownloadOptions(
    offlineRegionDefinition, // the OfflineRegionDefinition to download
    notificationOptions, // the NotificationOptions created before
    metadata // can be null
)
```

> Here's a tip!<br>
`OfflineDownloadOptions` has a secondary constructor that takes a `String` as third argument. It's a convenient method to store the region's name as region `metadata`: all this secondary constructor does is convert the `String` via `OfflineUtils.convertRegionName()`, then use the result to call the primary.

Now a new download can be started with

```kotlin
OfflineService.startDownload(context, offlineDownloadOptions)
```

### Cancel a download

To cancel an ongoing download just call

```kotlin
OfflineService.cancelDownload(context, regionId)
```

### Listen to events

`OfflineDownloadReceiver` handles all the events the `OfflineService` send.

Its private `activeDownloads` property, accessible via `getActiveDownloads()`, is a list of `OfflineDownload` that gets updated by the receiver (once registered) when certain events occur and is cleared when `unregister()` is called.

Extend `OfflineDownloadReceiver` and override only the methods/events you need, then register it with `register()` to start listening.

Available methods/events list:
* `onCreate(context: Context, download: OfflineDownload)`<br>
Download created.

* `onCreateError(context: Context, options: OfflineDownloadOptions, error: String?)`<br>
Download creation failed.

* `onDelete(context: Context, download: OfflineDownload)`<br>
Download canceled and region deleted.

* `onDeleteError(context: Context, download: OfflineDownload, error: String?)`<br>
Download canceled but region deletion failed.

* `onStatusChanged(context: Context, download: OfflineDownload)`<br>
Download status changed (progression or completion).

* `onObserverError(context: Context, download: OfflineDownload, reason: String?, message: String?)`<br>
Download observer failure.

* `onTileCountLimitExceeded(context: Context, download: OfflineDownload, limit: Long)`<br>
Download tile count exceeded.

* `onActiveDownloadsChanged(context: Context, activeDownloads: List<OfflineDownload>)`<br>
The active downloads list has changed because one of the events above has occurred (except `onCreateError()`, since in that case the download never became active). Override this method when all you want to do is observe the active downloads, without knowing the reasons they change.