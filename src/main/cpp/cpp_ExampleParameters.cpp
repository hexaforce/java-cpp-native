#include "cpp_ExampleParameters.h"
#include <iostream>
#include <string>

/*
 * Class:     cpp_ExampleParameters
 * Method:    sumIntegers
 * Signature: (II)J
 */
JNIEXPORT jlong JNICALL Java_cpp_ExampleParameters_sumIntegers(JNIEnv *env, jobject thisObject, jint first, jint second)
{
    std::cout << "C++: The numbers received are : " << first << " and " << second << std::endl;
    return (long)first + (long)second;
};

/*
 * Class:     cpp_ExampleParameters
 * Method:    sayHelloToMe
 * Signature: (Ljava/lang/String;Z)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_cpp_ExampleParameters_sayHelloToMe(JNIEnv *env,  jobject thisObject, jstring name, jboolean isFemale)
{
    const char *nameCharPointer = env->GetStringUTFChars(name, NULL);
    std::cout << "C++: The string received is: " << nameCharPointer << std::endl;
    std::string title;
    if (isFemale)
    {
        title = "Ms. ";
    }
    else
    {
        title = "Mr. ";
    }

    std::string fullName = title + nameCharPointer;
    return env->NewStringUTF(fullName.c_str());
};
