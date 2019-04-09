import Dependencies._

name := "spark-dojo"

version := "1.0"

scalaVersion := "2.12.8"

scalafmtOnCompile in ThisBuild := true

scalacOptions in ThisBuild ++= Seq("-Xfatal-warnings", "-deprecation", "-feature", "-language:postfixOps")

lazy val sparKafka = project.in(file("spark-kafka"))

lazy val sparkHdfs = project.in(file("spark-hdfs"))

lazy val sparkHive = project.in(file("spark-hive"))

lazy val sparkElasticSearch = project.in(file("spark-elasticsearch"))

lazy val sparkApps = project
  .in(file("."))
  .aggregate(sparKafka, sparkHdfs, sparkHive, sparkElasticSearch)
  .settings(
    libraryDependencies ++= Seq(
      scalaTest
    ),
    test in assembly          := {},
    parallelExecution in Test := false
  )
