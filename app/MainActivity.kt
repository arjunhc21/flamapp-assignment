package com.flamapp.assignment

import android.app.Activity
import android.os.Bundle
import android.view.TextureView
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var textureView: TextureView
    private lateinit var fpsLabel: TextView
    private lateinit var toggleButton: Button
    private lateinit var frameProcessor: FrameProcessor
    private lateinit var cameraModule: CameraModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textureView = TextureView(this)
        fpsLabel = TextView(this)
        toggleButton = Button(this).apply { text = "Toggle Edge" }

        frameProcessor = FrameProcessor()
        cameraModule = CameraModule { frame, w, h ->
            frameProcessor.onFrame(frame, w, h)
        }

        toggleButton.setOnClickListener {
            frameProcessor.toggleEdge()
        }

        cameraModule.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraModule.stop()
        frameProcessor.shutdown()
    }
}