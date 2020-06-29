#!/bin/bash -ex
SCRIPT_DIR=$(cd $(dirname $0); pwd)

cd $SCRIPT_DIR/java

javac -h ../cpp JNI/ExampleObjects.java
javac -h ../cpp JNI/ExampleParameters.java
javac -h ../cpp JNI/SayHello.java



