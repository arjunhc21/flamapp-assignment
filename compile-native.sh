#!/usr/bin/env bash

if [ -z "${ANDROID_NDK_HOME:-}" ]; then
  echo "Please set ANDROID_NDK_HOME"
  exit 1
fi

mkdir -p build-native
cd build-native

cmake -DANDROID_NDK=$ANDROID_NDK_HOME \
      -DANDROID_ABI=arm64-v8a \
      -DANDROID_PLATFORM=android-24 ..

cmake --build . -- -j4