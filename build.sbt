val baseVersion = "6.0.0-M1"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    sbtrelease.ReleasePlugin.projectSettings ++
    Seq(
      organization := "com.typesafe.sbteclipse",
      name := "sbteclipse-plugin",
      version := baseVersion,
      sbtPlugin := true,
      (GlobalScope / sbtVersion) := {
        System.getProperty("sbt.build.version", (GlobalScope / sbtVersion).value)
      },
      scalacOptions ++= Seq("-unchecked", "-deprecation", "-target:jvm-1.8"),
      scalaVersion := "2.12.17",
      libraryDependencies ++= Seq(
        "org.scala-lang.modules" %% "scala-xml"     % "2.1.0",
        "org.scalaz"             %% "scalaz-core"   % "7.2.34",
        "org.scalaz"             %% "scalaz-effect" % "7.2.34",
        "org.scalatest"          %% "scalatest"     % "3.2.3" % "test"
      ),
      publishMavenStyle := false,
      licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
      (Compile / packageDoc / publishArtifact) := false,
      (Compile / packageSrc / publishArtifact) := false,
      scriptedBufferLog := false,
      scriptedLaunchOpts ++= Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    )
  )
