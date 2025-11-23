package com.flamapp.assignment

interface IFrameProcessor {
    fun onFrame(data: ByteArray, width: Int, height: Int)
    fun toggleEdge()
    fun shutdown()
}