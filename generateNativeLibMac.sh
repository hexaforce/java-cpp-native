#!/bin/bash -ex
SCRIPT_DIR=$(cd $(dirname $0); pwd)
cd $SCRIPT_DIR/src/main/cpp

JDK_DIR=`/usr/libexec/java_home -v 8`
cp -f $JDK_DIR/include/jni.h .
cp -f $JDK_DIR/include/darwin/jni_md.h .

# Create the header with javac -h . ClassName.java
# Remember to set your JAVA_HOME env var

g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin cpp_ExampleObjects.cpp -o cpp_ExampleObjects.o
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin cpp_ExampleParameters.cpp -o cpp_ExampleParameters.o
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin cpp_SayHello.cpp -o cpp_SayHello.o
mkdir -p $SCRIPT_DIR/native/macos
if [ -e ../../../native/macos/libnative.dylib ]; then
  rm ../../../native/macos/libnative.dylib
fi
g++ -dynamiclib -o ../../../native/macos/libnative.dylib cpp_SayHello.o cpp_ExampleParameters.o cpp_ExampleObjects.o -lc

find . -name '*.o' | xargs rm 
rm jni.h
rm jni_md.h 