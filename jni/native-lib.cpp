#include "image_ops.hpp"
#include <jni.h>

extern "C" {

JNIEXPORT jbyteArray JNICALL
Java_com_flamapp_assignment_JNI_1Bridge_processGray(JNIEnv* env, jobject,
                                                    jbyteArray input, jint w, jint h) {
    jbyte* bytes = env->GetByteArrayElements(input, NULL);
    std::vector<uint8_t> out = image_ops::rgb_to_gray((uint8_t*)bytes, w, h);

    std::vector<uint8_t> rgb(w*h*3);
    for (int i = 0; i < w*h; i++) {
        rgb[i*3] = rgb[i*3+1] = rgb[i*3+2] = out[i];
    }

    jbyteArray result = env->NewByteArray(rgb.size());
    env->SetByteArrayRegion(result, 0, rgb.size(), (jbyte*)rgb.data());
    env->ReleaseByteArrayElements(input, bytes, JNI_ABORT);
    return result;
}

JNIEXPORT jbyteArray JNICALL
Java_com_flamapp_assignment_JNI_1Bridge_processCanny(JNIEnv* env, jobject,
                                                     jbyteArray input, jint w, jint h) {
    jbyte* bytes = env->GetByteArrayElements(input, NULL);
    std::vector<uint8_t> out = image_ops::canny((uint8_t*)bytes, w, h);

    jbyteArray result = env->NewByteArray(out.size());
    env->SetByteArrayRegion(result, 0, out.size(), (jbyte*)out.data());
    env->ReleaseByteArrayElements(input, bytes, JNI_ABORT);
    return result;
}
}