#!/bin/bash -ex
SCRIPT_DIR=$(cd $(dirname $0); pwd)

cd $SCRIPT_DIR/cpp

JAVA_HOME=`/usr/libexec/java_home -v 8`

# Create the header with javac -h . ClassName.java
# Remember to set your JAVA_HOME env var

g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin ExampleObjects.cpp -o ExampleObjects.o
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin ExampleParameters.cpp -o ExampleParameters.o
g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin SayHello.cpp -o SayHello.o

mkdir -p $SCRIPT_DIR/native
if [ -e $SCRIPT_DIR/native/libnative.dylib ]; then
  rm $SCRIPT_DIR/native/libnative.dylib
fi

g++ -dynamiclib -o $SCRIPT_DIR/native/libnative.dylib SayHello.o ExampleParameters.o ExampleObjects.o -lc

find . -name '*.o' | xargs rm 
