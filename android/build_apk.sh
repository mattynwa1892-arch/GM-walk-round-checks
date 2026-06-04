#!/bin/bash
set -e

echo "Building GM Walk-Around Android App..."
cd "$(dirname "$0")"

# Clean
./gradlew clean

# Build Debug APK (easiest to install)
./gradlew assembleDebug

echo ""
echo "✅ BUILD COMPLETE!"
echo ""
echo "Your APK is here:"
echo "app/build/outputs/apk/debug/app-debug.apk"
echo ""
echo "To install on your phone:"
echo "1. Connect phone via USB"
echo "2. Run: adb install app/build/outputs/apk/debug/app-debug.apk"
echo ""
echo "OR transfer the APK file directly to your phone and tap it to install"
