import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "hello-world-api",
    // libraryDependencies +=
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "com.typesafe.akka" %% "akka-actor" % "2.5.13",
      "com.typesafe.akka" %% "akka-stream" % "2.5.13",
      "com.typesafe.akka" %% "akka-http" % "10.1.3"
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
