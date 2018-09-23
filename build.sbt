name := "spark-sbt-template"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-core" % "2.2.0" % "provided",
	"org.apache.spark" %% "spark-sql" % "2.2.0" % "provided",
	"log4j" % "log4j" % "1.2.17",
	"org.scalactic" %% "scalactic" % "3.0.5",
	"org.scalatest" %% "scalatest" % "3.0.5" % Test,
	"org.scala-sbt" %% "compiler-bridge" % "1.1.7" % Test
)

assemblyShadeRules in assembly := Seq(
	ShadeRule.rename("org.apache.commons.io.**" -> "shadeio.@1").inAll
)
