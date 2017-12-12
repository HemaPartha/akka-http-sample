#!/usr/bin/env bash
echo Publishing docker image.........
echo $PACKAGE_NAME
echo $BUILD_NUMBER

docker login -u $DOCKER_LOGIN -p $DOCKER_PASSWORD
docker build -t akka-http-sample .
docker images
docker tag akka-http-sample arunkoshi/samples:$PACKAGE_NAME-$BUILD_NUMBER
docker push arunkoshi/samples:$PACKAGE_NAME-$BUILD_NUMBER

