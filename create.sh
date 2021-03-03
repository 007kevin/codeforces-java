#!/bin/bash
if [ -z "$1" ]
then
    echo "No argument supplied"
    exit 0
fi
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
NAME=$1
FILENAME=$NAME.java
OUTPUT=$DIR/src/$FILENAME
cat $DIR/src/Template.java | sed "s/Template/$NAME/g" > $OUTPUT
echo $OUTPUT
