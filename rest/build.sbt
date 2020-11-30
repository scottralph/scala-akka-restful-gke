name := "rest"

version := "0.1"

scalaVersion := "2.13.2"

val AkkaVersion = "2.6.8"
val AkkaTypedVersion = "2.6.10"
val AkkaHttpVersion = "10.2.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % AkkaTypedVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaTypedVersion,
)

