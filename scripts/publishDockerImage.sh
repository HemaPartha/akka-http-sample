#!/usr/bin/env bash
echo Publishing docker image.........
echo $TRAVIS_BUILD_NUMBER
echo $BUILD_NUMBER

docker login -u $DOCKER_LOGIN -p $DOCKER_PASSWORD
docker build -t akka-http-sample .
docker images
docker tag akka-http-sample arunkoshi/samples:akka-http-sample-$BUILD_NUMBER
docker push arunkoshi/samples:akka-http-sample-$BUILD_NUMBER

