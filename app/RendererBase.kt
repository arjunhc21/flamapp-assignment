package com.flamapp.assignment

abstract class RendererBase {
    abstract fun onSurfaceCreated()
    abstract fun onSurfaceChanged(width: Int, height: Int)
    abstract fun onDrawFrame()
}