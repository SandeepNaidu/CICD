name := "CICD"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.6",
  "com.typesafe.akka" %% "akka-http" % "10.0.6",
  "com.typesafe.akka" %% "akka-actor" % "2.5.6",
  "com.typesafe.akka" %% "akka-stream" % "2.5.6",
  "com.ning"  %  "async-http-client" % "1.9.38",
  "org.jsoup" % "jsoup" % "1.8.3",
  "com.twitter" %% "algebird-core" % "0.13.3",
  "org.scalatest" %% "scalatest" % "3.0.3" % Test,
  "junit" % "junit" % "4.11" % Test
)

