# 🛰️ Android DalvikVM Standalone MiniHTTP Server

---

## Overview
A minimal proof-of-concept showing that you can run **pure Java code directly on Android’s Dalvik/ART runtime**, completely **outside the Android framework**.  
This demo implements a tiny multi-threaded HTTP server that listens on port `8080` and responds with a simple text message.

---

## Requirements
- Android SDK (for `d8` and `android.jar`)  
- JDK 11–21 (tested with OpenJDK 21)  
- A device or emulator with `dalvikvm` available (`/system/bin/dalvikvm`)  
- `adb` access for file transfer and port forwarding

---

## Build & Run

```bash
make
make push run
```
## Test From Host

```bash
adb forward tcp:8080 tcp:8080
curl localhost:8080
```
