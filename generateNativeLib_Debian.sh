#!/bin/bash -ex
SCRIPT_DIR=$(cd $(dirname $0); pwd)

cd $SCRIPT_DIR/src/main/cpp

# yum install gcc-c++ java-1.8.0-openjdk-devel.x86_64
JAVA_HOME=`readlink -f $(which java)`
JAVA_HOME=`dirname $JAVA_HOME`
JAVA_HOME=`dirname $JAVA_HOME`

# Create the header with javac -h . ClassName.java
# Remember to set your JAVA_HOME env var

g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux cpp_ExampleObjects.cpp -o cpp_ExampleObjects.o
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux cpp_ExampleParameters.cpp -o cpp_ExampleParameters.o
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux cpp_SayHello.cpp -o cpp_SayHello.o

mkdir -p $SCRIPT_DIR/native/linux_x86_64
if [ -e ../../../native/linux_x86_64/libnative.so ]; then
  rm ../../../native/linux_x86_64/libnative.so
fi

g++ -shared -fPIC -o ../../../native/linux_x86_64/libnative.so cpp_SayHello.o cpp_ExampleParameters.o cpp_ExampleObjects.o -lc
# Don't forget to set java.library.path to point to the folder where you have the libnative you're loading.

find . -name '*.o' | xargs rm 
