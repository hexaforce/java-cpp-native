#include "cpp_SayHello.h"
#include <iostream>

/*
 * Class:     cpp_SayHello
 * Method:    sayHello
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_cpp_SayHello_sayHello(JNIEnv *env, jobject)
{
    std::string hello = "Hello from C++ !!";
    std::cout << hello << std::endl;
    return env->NewStringUTF(hello.c_str());
};