#!/bin/bash -ex
SCRIPT_DIR=$(cd $(dirname $0); pwd)

cd $SCRIPT_DIR/cpp

LIB_NAME=libnative.dylib

JAVA_HOME=`/usr/libexec/java_home -v 1.8`

# Create the header with javac -h . ClassName.java
# Remember to set your JAVA_HOME env var

filelist=(
    "ExampleObjects"
    "ExampleParameters"
    "SayHello"
)

compiled=''
for file in "${filelist[@]}" ; do
    g++ -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin ${file}.cpp -o ${file}.o
    compiled=${compiled}' '${file}.o
done

mkdir -p $SCRIPT_DIR/native
if [ -e $SCRIPT_DIR/native/$LIB_NAME ]; then
  rm $SCRIPT_DIR/native/$LIB_NAME
fi

g++ -dynamiclib -o $SCRIPT_DIR/native/$LIB_NAME $compiled -lc

find . -name '*.o' | xargs rm 
