FROM java:8
WORKDIR /myApp
ADD target/scala-2.11/akka-http-sample-assembly-1.0.0-SNAPSHOT.jar akka-http-sample-assembly-1.0.0-SNAPSHOT.jar
ENV AKKA_HTTP_SAMPLE_PORT 9090
EXPOSE 9090
CMD java -jar akka-http-sample-assembly-1.0.0-SNAPSHOT.jar 0.0.0.0
