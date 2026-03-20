# Call Forwarding

A simple Android app to manage call forwarding settings using USSD codes.

## Features

- **Activate** call forwarding to a specified phone number
- **Deactivate** call forwarding
- **Check status** of current call forwarding settings

Tapping any button opens the system dialer pre-filled with the appropriate USSD code — no calls are placed automatically.

## Requirements

- Android 8.0 (API 26) or higher
- A SIM card with call forwarding support from your carrier

## How It Works

The app encodes standard GSM call forwarding USSD codes and sends them to the system dialer via `ACTION_DIAL`:

| Action     | USSD Code        |
|------------|------------------|
| Activate   | `*21*[number]#`  |
| Deactivate | `#21#`           |
| Status     | `*#21#`          |

## Tech Stack

- **Language:** Kotlin 2.0
- **UI:** Jetpack Compose + Material3
- **Min SDK:** 26 | **Target SDK:** 35

## Building

```bash
./gradlew assembleDebug
```

Run code quality checks before submitting changes:

```bash
./gradlew format   # auto-format with ktlint
./gradlew ktlint   # lint + static analysis (detekt)
```
