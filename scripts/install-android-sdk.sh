#!/usr/bin/env bash
set -euo pipefail

# This script installs a minimal Android SDK & build tools for CI/local container use.
# Idempotent: will skip packages already installed.

SDK_ROOT="${ANDROID_HOME:-$HOME/android-sdk}"
CMDLINE_TOOLS_DIR="$SDK_ROOT/cmdline-tools"
TOOLS_VERSION="11076708" # Update as needed

mkdir -p "$SDK_ROOT"
export ANDROID_HOME="$SDK_ROOT"
export PATH="$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"

if ! command -v sdkmanager >/dev/null 2>&1; then
  echo "Downloading Android commandline tools..."
  tmpfile=$(mktemp)
  curl -sSL -o "$tmpfile" "https://dl.google.com/android/repository/commandlinetools-linux-${TOOLS_VERSION}_latest.zip"
  mkdir -p "$CMDLINE_TOOLS_DIR"
  unzip -q "$tmpfile" -d "$CMDLINE_TOOLS_DIR"
  mv "$CMDLINE_TOOLS_DIR/cmdline-tools" "$CMDLINE_TOOLS_DIR/latest"
  rm -f "$tmpfile"
fi

yes | sdkmanager --licenses > /dev/null || true

# Required packages (adjust compileSdk / build tools to project values)
PKGS=(platform-tools "build-tools;34.0.0" "platforms;android-34")

echo "Installing required packages (idempotent)..."
set +e
yes | sdkmanager "${PKGS[@]}" || true
set -e

echo "Installed packages:" && (sdkmanager --list_installed || true)

echo "Android SDK installed at $ANDROID_HOME"
