#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_yuqinyidev_android_yyandroid_fw_ui_activity_BaseActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
