import Dependencies._

lazy val root = (project in file("."))
.settings(
  organization := "algru",
  name := "anti-duplication-utilities",
  version := "0.1",
  scalaVersion := "2.13.5",

  githubOwner := "algru",
  githubRepository := "anti-duplication-utilities",
  githubTokenSource := TokenSource.GitConfig("github.token"),

  libraryDependencies ++= Seq(
    logging,
    scalaConfig,
    scalaTest,
  ).flatten
)