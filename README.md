# MyAndroidApp
# MyAndroidApp

![Android CI](../../actions/workflows/android-ci.yml/badge.svg)

## Overview
This sample Android application demonstrates a simple two-tab interface:
1. Calendar tab: View upcoming 14 days and see reservations per day. Double tap a day (with or without an existing reservation) to create/edit/delete a reservation. Each reservation links to a car.
2. Cars tab: Manage cars (name, model, license number, unique color).

Local persistence is implemented using Room with two entities: `Car` and `Reservation`.

## Features
- Tab navigation using `TabLayout` + `ViewPager2`.
- Room database with `Car` and `Reservation` tables; Car color is unique (indexed unique constraint).
- Add/Delete cars; prevents duplicate color usage.
- Add/Edit/Delete reservations with date pickers and car selection.
- Basic 14-day rolling calendar list with double-tap gesture to open reservation dialog.

## Build Requirements
- Android Studio Giraffe/Latest (or Gradle CLI with Android SDK installed)
- Minimum SDK 21, Target SDK 34
- Kotlin

## How to Build Locally
Open the project root (`MyAndroidApp`) in Android Studio and let it sync. Then run the `app` configuration.

Or via command line (with proper ANDROID_HOME / sdkmanager installed):

```
./gradlew assembleDebug
```

APK output will be under `app/build/outputs/apk/debug/`.

## Continuous Integration
Every push / PR to `main` or `master` triggers GitHub Actions workflow building a debug APK.
Download artifact from the workflow run (Actions tab -> latest run -> Artifacts -> `app-debug-apk`).

## How to Use
1. Launch the app.
2. Navigate between Calendar and Cars tabs.
3. In Cars tab, tap "Add Car" to create a car (enter hex color like `#FF0000`).
4. In Calendar tab, double tap a day: if no reservation, create one; if existing, edit first reservation for that day.
5. In reservation dialog you can adjust dates, change car, save, or delete (when editing).

## Notes & Improvements
- Calendar display is simplified (first reservation per day picked on double tap). Could be improved to pick exact line tapped.
- No overlap prevention for reservations; can be added in DAO queries/validation.
- Uses `fallbackToDestructiveMigration()` for schema version 2; add proper migrations for production.
- Error handling and user feedback (e.g., duplicate color snackbars) can be enhanced.

## License
MIT (add a LICENSE file if needed).

MyAndroidApp is a native Android application that utilizes a local database to store and manage data. This project is built using Kotlin and follows the MVVM architecture pattern.

## Project Structure

The project consists of the following key components:

- **MainActivity.kt**: The entry point of the application, responsible for setting up the user interface and handling user interactions.
- **AppDatabase.kt**: Defines the Room database for managing local data storage.
- **Dao.kt**: Contains the Data Access Object (DAO) interface for interacting with the database.
- **Entity.kt**: Represents the data model for the database, including annotations for table and column definitions.
- **activity_main.xml**: The layout file for the main activity, defining the user interface components.
- **strings.xml**: Contains string resources for easy localization and management of text.
- **AndroidManifest.xml**: Declares application components and required permissions.
- **build.gradle**: Gradle build configuration for the app module.
- **settings.gradle**: Specifies the modules included in the project.

## Setup Instructions

1. **Clone the Repository**: 
   ```
   git clone <repository-url>
   ```

2. **Open the Project**: Open the project in your preferred IDE (e.g., Android Studio).

3. **Sync Gradle**: Ensure all dependencies are resolved by syncing the Gradle files.

4. **Run the Application**: Connect an Android device or start an emulator, then run the application from the IDE.

## Features

- Local database management using Room.
- User-friendly interface for data interaction.
- Support for future enhancements and features.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.