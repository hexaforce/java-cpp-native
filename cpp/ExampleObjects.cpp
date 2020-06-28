#include "ExampleObjects.h"
#include <iostream>
/*
 * Class:     ExampleObjects
 * Method:    createUser
 * Signature: (Ljava/lang/String;D)LUserData;
 */
JNIEXPORT jobject JNICALL Java_ExampleObjects_createUser(JNIEnv *env, jobject thisObject, jstring name, jdouble balance)
{
  // Create the object of the class UserData
  jclass userDataClass = env->FindClass("UserData");
  jobject newUserData = env->AllocObject(userDataClass);

  // Get UserData fields to set
  jfieldID nameField = env->GetFieldID(userDataClass, "name", "Ljava/lang/String;");
  jfieldID balanceField = env->GetFieldID(userDataClass, "balance", "D");

  // Set the values of the new object
  env->SetObjectField(newUserData, nameField, name);
  env->SetDoubleField(newUserData, balanceField, balance);

  // Return the created object
  return newUserData;
};

/*
 * Class:     ExampleObjects
 * Method:    printUserData
 * Signature: (LUserData;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_ExampleObjects_printUserData(JNIEnv *env, jobject thisObject, jobject userData)
{
  // Find the class method id
  jclass userDataClass = env->GetObjectClass(userData);
  jmethodID methodId = env->GetMethodID(userDataClass, "getUserInfo", "()Ljava/lang/String;");

  // Call the object method and get the result
  jstring result = (jstring)env->CallObjectMethod(userData, methodId);

  // Print the result
  std::cout << "C++: User data is: " << env->GetStringUTFChars(result, NULL) << std::endl;

  return result;
};
