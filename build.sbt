name := """variant-viewer"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.7"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies ++= {
  Seq(
    guice,
    javaJdbc,
    filters,
    "org.postgresql" % "postgresql" % "42.2.2",
    "org.mockito" % "mockito-core" % "2.10.0" % "test"
  )
}

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
