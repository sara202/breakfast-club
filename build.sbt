name := """breakfast-club"""

version := "0.1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.webjars" % "bootswatch-default" % "3.3.5+4",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.jsoup" % "jsoup" % "1.9.2" % Test
)
