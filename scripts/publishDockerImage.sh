#!/usr/bin/env bash
echo Publishing docker image.........
echo $TRAVIS_BUILD_NUMBER
echo $AKKA_CONTAINER_NAME
pwd
ls -lrh
cd ..
pwd
ls -lrh
docker build -t akka-sample:0.1 .
docker images
