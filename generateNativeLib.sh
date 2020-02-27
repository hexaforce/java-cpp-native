#!/bin/bash -ex
SCRIPT_DIR=$(cd $(dirname $0); pwd)
cd $SCRIPT_DIR

JDK_DIR=`readlink -f $(which java)`
JDK_DIR=`dirname $JDK_DIR`
JDK_DIR=`dirname $JDK_DIR`
# Fedora
JDK_DIR=`dirname $JDK_DIR`

cp -f $JDK_DIR/include/jni.h .
cp -f $JDK_DIR/include/linux/jni_md.h .

# Create the header with javac -h . ClassName.java
# Remember to set your JAVA_HOME env var
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux cpp_ExampleObjects.cpp -o cpp_ExampleObjects.o
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux cpp_ExampleParameters.cpp -o cpp_ExampleParameters.o
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux cpp_SayHello.cpp -o cpp_SayHello.o
$SCRIPT_DIR/native/linux_x86_64
g++ -shared -fPIC -o ../../../native/linux_x86_64/libnative.so cpp_SayHello.o cpp_ExampleParameters.o cpp_ExampleObjects.o -lc
# Don't forget to set java.library.path to point to the folder where you have the libnative you're loading.
