# Portfolio Management

A Kotlin Multiplatform (KMP) application for managing investment portfolios, targeting Android, iOS, Web, and Desktop.

## Project Structure

This project uses a modular structure to share code across platforms:

* **`/app`**: Contains platform-specific entry points and shared UI.
    * **`androidApp`**: Android-specific application code.
    * **`iosApp`**: iOS-specific application code (SwiftUI).
    * **`webApp`**: Web-specific application code (Compose HTML/Wasm).
    * **`shared`**: Shared UI components and logic using Compose Multiplatform.
* **`/core`**: Common business logic, data models, and utilities shared between the client apps and the server.
* **`/server`**: A Ktor-based backend server for managing portfolio data.

## Features (Planned)

*   Real-time portfolio tracking.
*   Support for multiple asset classes (Stocks, Crypto, etc.).
*   Performance analytics and reporting.
*   Cross-platform synchronization.

## Running the Applications

### Android
```sh
./gradlew :app:androidApp:assembleDebug
```

### Server
```sh
./gradlew :server:run
```

### Web
*   **Wasm (Modern browsers):** `./gradlew :app:webApp:wasmJsBrowserDevelopmentRun`
*   **JS (Compatibility):** `./gradlew :app:webApp:jsBrowserDevelopmentRun`

### iOS
Open `app/iosApp/iosApp.xcodeproj` in Xcode and run from there.

## Running Tests

*   **Android:** `./gradlew :app:shared:testAndroidHostTest`
*   **Server:** `./gradlew :server:test`
*   **Web:** `./gradlew :app:shared:wasmJsTest`
*   **iOS:** `./gradlew :app:shared:iosSimulatorArm64Test`

---

Built with [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html) and [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform).
