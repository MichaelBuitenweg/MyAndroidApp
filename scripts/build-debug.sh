#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
cd "$REPO_ROOT"

# Expected SDK root (align with install script default)
SDK_ROOT="${ANDROID_HOME:-$HOME/android-sdk}"
export ANDROID_HOME="$SDK_ROOT"
export ANDROID_SDK_ROOT="$SDK_ROOT"
export PATH="$SDK_ROOT/cmdline-tools/latest/bin:$SDK_ROOT/platform-tools:$PATH"

# Ensure we are using JDK 17 (AGP 8.1 / Kotlin 1.9 + KAPT not fully compatible with JDK 21 strong encapsulation)
JAVA_REQUIRED_MAJOR=17
CURRENT_JAVA_VERSION=$(java -version 2>&1 | head -n1 | sed -E 's/.*version "([0-9]+).*/\1/') || CURRENT_JAVA_VERSION=0
if [ "$CURRENT_JAVA_VERSION" -gt "$JAVA_REQUIRED_MAJOR" ]; then
  if [ ! -d /usr/lib/jvm/java-17-openjdk-amd64 ]; then
    echo "Installing OpenJDK 17 (current Java $CURRENT_JAVA_VERSION)..." >&2
    sudo apt-get update -y >/dev/null
    sudo apt-get install -y openjdk-17-jdk-headless >/dev/null
  fi
  export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
  export PATH="$JAVA_HOME/bin:$PATH"
  echo "Switched to JDK 17: $(java -version 2>&1 | head -n1)" >&2
fi

if ! command -v sdkmanager >/dev/null 2>&1; then
  echo "Android SDK not found, installing..." >&2
  "$SCRIPT_DIR/install-android-sdk.sh"
  # Re-export after install in case script was run in subshell
  export ANDROID_HOME="$SDK_ROOT"
  export ANDROID_SDK_ROOT="$SDK_ROOT"
  export PATH="$SDK_ROOT/cmdline-tools/latest/bin:$SDK_ROOT/platform-tools:$PATH"
fi

# Ensure local.properties has sdk.dir for Gradle (Gradle doesn't inherit env on some CI contexts)
if [ ! -f local.properties ] || ! grep -q "^sdk.dir=" local.properties; then
  echo "sdk.dir=$SDK_ROOT" > local.properties
fi

# Ensure wrapper jar exists; regenerate if missing
if [ ! -f gradle/wrapper/gradle-wrapper.jar ]; then
  echo "Wrapper jar missing, generating..."
  gradle wrapper --gradle-version 8.2
fi

chmod +x gradlew
./gradlew :app:assembleDebug --stacktrace --no-daemon

APK_PATH="app/build/outputs/apk/debug/app-debug.apk"
if [ -f "$APK_PATH" ]; then
  echo "Build succeeded: $APK_PATH"
  ls -lh "$APK_PATH"
else
  echo "APK not found" >&2
  exit 1
fi
