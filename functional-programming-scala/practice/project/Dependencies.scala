import sbt._

object Dependencies {
  lazy val scalaTest = Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % Test,
    "junit" % "junit" % "4.10" % Test
  )
}
