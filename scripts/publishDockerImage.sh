#!/usr/bin/env bash
echo Publishing docker image.........
echo $TRAVIS_BUILD_NUMBER
echo $AKKA_CONTAINER_NAME
echo $DOCKER_LOGIN

docker login -u $DOCKER_LOGIN -p $DOCKER_PASSWORD
docker build -t akka-http-sample .
docker images
docker tag akka-http-sample arunkoshi/samples:akka-http-sample-$TRAVIS_BUILD_NUMBER
docker push arunkoshi/samples:akka-http-sample-$TRAVIS_BUILD_NUMBER

