# Flamapp.AI — Intern Technical Assessment (R&D Sample Project)

This project showcases a mock architecture for a real-time camera processing pipeline:
Android (Kotlin) → JNI → Native C++ (OpenCV-like) → OpenGL ES → Web Viewer (TypeScript).

This structure is created based on the assignment instructions provided.  
This repository includes:
- Android-side mock camera & frame processor
- JNI bridge
- Native C++ image ops
- OpenGL texture renderer
- Web viewer
- Technical documentation
- Assets folder
- Build scripts

---

# Features Implemented

## Android (Kotlin)
- Mock Camera module
- Frame processing pipeline
- JNI bridge integration
- Toggle grayscale / edge mode

## Native (C++ + OpenCV-style)
- RGB → Gray conversion
- Canny edge detection (Sobel-based)
- Frame buffer handling

## OpenGL ES
- Texture loader
- Shader utilities
- Basic renderer

## Web Viewer (TypeScript)
- HTML canvas viewer
- FPS overlay (simulated)
- Loads processed mock frame

---

# Setup Instructions

### Requirements
- macOS (M1 supported)
- VS Code
- Git
- Android Studio (for NDK only)
- Node + TypeScript

### Steps