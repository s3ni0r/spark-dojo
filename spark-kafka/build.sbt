import Dependencies._

libraryDependencies ++= Seq(
  sparkCore % Provided,
  sparkSql  % Provided
)

assemblyOutputPath in assembly := file("./jobs/spark-kafka-job.jar")

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _ *) => {
    xs.map(_.toLowerCase) match {
      case ("manifest.mf" :: Nil) => MergeStrategy.discard
      case _                      => MergeStrategy.discard
    }
  }
  case "rootdoc.txt"           => MergeStrategy.discard
  case "conf/application.conf" => MergeStrategy.concat
  case _                       => MergeStrategy.first
}
