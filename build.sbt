ThisBuild / version := "1.0.0"
ThisBuild / scalaVersion := "2.12.15"

val sparkVersion = "3.2.1"

lazy val root = (project in file("."))
  .settings(
    name := "scalapb-spark-issue",
//    Compile / PB.targets := Seq(
//      scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
//    ),
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
      "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
      "com.thesamet.scalapb" %% "sparksql32-scalapb0_11" % "1.0.0",
      "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
    ),

//    assembly / assemblyShadeRules := Seq(
//      ShadeRule.rename("com.google.protobuf.**" -> "shadeproto.@1").inAll,
//      ShadeRule.rename("scala.collection.compat.**" -> "shadecompat.@1").inAll
//    ),
//
//    assembly / assemblyMergeStrategy := {
//      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
//      case x => MergeStrategy.first
//    }
  )
