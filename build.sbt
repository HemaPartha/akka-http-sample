name := "akka-http-sample"

version := "0.1"

scalaVersion := "2.11.11"


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.11",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.11",
  "org.scalatest" %% "scalatest" % "3.0.3" % Test,
  "junit" % "junit" % "4.11" % Test
)
