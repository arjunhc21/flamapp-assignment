package com.flamapp.assignment

import java.util.*
import kotlin.concurrent.timerTask

class CameraModule(private val onFrame: (ByteArray, Int, Int) -> Unit) {

    private var timer: Timer? = null
    private val width = 640
    private val height = 480

    fun start() {
        timer = Timer("MockCamera", true)
        timer?.scheduleAtFixedRate(timerTask {
            val frame = ByteArray(width * height * 3)
            for (i in frame.indices) frame[i] = (i % 256).toByte()
            onFrame(frame, width, height)
        }, 0, 66)
    }

    fun stop() {
        timer?.cancel()
    }
}