name := "progfun"

version := "1.0.0"

scalaVersion := "2.12.9"

libraryDependencies ++= Seq(

  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "junit" % "junit" % "4.12" % Test,

  "org.scalacheck" %% "scalacheck" % "1.14.0",
  "io.reactivex" %% "rxscala" % "0.26.5",
  "org.json4s" %% "json4s-native" % "3.6.7",

  "org.scala-lang.modules" %% "scala-swing" % "2.1.1",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  "org.scala-lang.modules" %% "scala-async" % "0.10.0",
  "org.scala-lang" % "scala-reflect" % "2.12.9",

  "net.databinder.dispatch" %% "dispatch-core" % "0.13.4",

  "org.slf4j" % "slf4j-api" % "1.7.28",
  "org.slf4j" % "slf4j-simple" % "1.7.28",

  "com.squareup.retrofit2" % "retrofit" % "2.6.1",

  "com.typesafe.akka" %% "akka-actor" % "2.5.25",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.25"
)
