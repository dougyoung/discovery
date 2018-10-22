import java.io.FileOutputStream
import java.nio.channels.Channels
import java.nio.file.{Files, Path, Paths}

name := course.value + "-" + assignment.value

scalaVersion := "2.11.12"

scalacOptions ++= Seq("-deprecation")

courseId := "e8VseYIYEeWxQQoymFg8zQ"

resolvers += Resolver.sonatypeRepo("releases")

// grading libraries
libraryDependencies += "junit" % "junit" % "4.10" % Test
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.0",
  "org.apache.spark" %% "spark-sql" % "2.1.0"
)

// include the common dir
commonSourcePackages += "common"

// Custom

lazy val downloadResources = taskKey[Unit]("Download dataset and write it to resources")
lazy val datasetUrl = new URL("http://alaska.epfl.ch/~dockermoocs/bigdata/wikipedia.dat")
lazy val datasetPath = Paths.get("src/main/resources/wikipedia/wikipedia.dat")

def downloadIfNotExists(url: URL, path: Path): Unit = {
  if (Files.notExists(datasetPath)) {
    println(s"Downloading $url to $path")
    Files.createDirectory(datasetPath.getParent)
    Files.createFile(datasetPath)
    val input = Channels.newChannel(datasetUrl.openStream)
    val output = new FileOutputStream(datasetPath.toString).getChannel
    output.transferFrom(input, 0, Long.MaxValue)
  }
}

downloadResources := {
  downloadIfNotExists(datasetUrl, datasetPath)
}

compile in Compile <<= (compile in Compile).dependsOn(downloadResources)
