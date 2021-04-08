name := "comment-form"

version := "0.1"

scalaVersion := "2.12.13"

idePackagePrefix := Some("hip.shining.form")

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % "test",
  "org.scalatest" %% "scalatest" % "3.2.5" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % "test",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
)

lazy val assemblyCommonSettings = Seq(
  version := "1.0-SNAPSHOT",
  organization := "hip.shining",
  scalaVersion := "2.12.13",
  assemblyMergeStrategy in assembly := {
    case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith ".properties" => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith ".class" => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith ".conf" => MergeStrategy.concat
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  },
  test in assembly := {}
)

lazy val root = (project in file("."))
  .settings(assemblyCommonSettings: _*)
  .settings(
    mainClass in assembly := Some("play.core.server.ProdServerStart"),
    assemblyJarName in assembly := "commentForm.jar"
  )
  .enablePlugins(PlayScala)