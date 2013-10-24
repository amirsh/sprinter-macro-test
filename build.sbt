scalaVersion := "2.10.3"

name := "Sprinter Test"

libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)

libraryDependencies += "org.scala-lang" %% "sprinter" % "0.2.0"
