
lazy val basicSettings: Seq[Def.Setting[_]] = Seq(
  homepage := Some(new URL("https://github.com/rojanu/multi-module-test-scope")),
  organization := "com.github.rojanu",
  description := "multi-module-test-scope",
  scalaVersion := "2.12.8",
  version := "0.1",
  name := "multi-module-test-scope",
  javacOptions ++= Seq("-encoding", "UTF-8"),
  scalacOptions := Seq("-encoding", "utf8", "-feature", "-unchecked", "-deprecation", "-target:jvm-1.8", "-language:_", "-Ywarn-adapted-args"),
)

lazy val `platform-common` = (project in file("modules/platform-common"))
  .settings(
    basicSettings,
    name := "platform-common"
  )

lazy val `client-test` = (project in file("modules/client-test"))
  .dependsOn(`platform-common` % "compile->test")
  .settings(
    basicSettings,
    name := "client-test"
  )

lazy val root = (project in file("."))
  .aggregate(
    `platform-common`,
    `client-test`
  )
  .settings(
    basicSettings,
    publishArtifact := false
  )
