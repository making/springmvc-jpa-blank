#!/bin/sh
DATABASES="mysql postgresql h2 hsql"
for d in $DATABASES; do
    mvn clean test -P $d
done