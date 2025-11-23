package com.flamapp.assignment

class FrameProcessor : IFrameProcessor {

    private var useEdge = true
    private val nativeBridge = JNI_Bridge.instance
    private val glRenderer = GLRendererStub()

    override fun onFrame(data: ByteArray, width: Int, height: Int) {
        val output = if (useEdge) {
            nativeBridge.processCanny(data, width, height)
        } else {
            nativeBridge.processGray(data, width, height)
        }

        glRenderer.updateTexture(output, width, height)
    }

    override fun toggleEdge() {
        useEdge = !useEdge
    }

    override fun shutdown() {
        nativeBridge.release()
        glRenderer.release()
    }
}

class GLRendererStub {
    fun updateTexture(data: ByteArray, width: Int, height: Int) {}
    fun release() {}
}