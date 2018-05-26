import Dependencies._

name := "Functional Programming in Scala Practice Exercises"

scalaVersion := "2.11.12"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "practice",
    libraryDependencies ++= scalaTest
  )
