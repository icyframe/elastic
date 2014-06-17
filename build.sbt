import com.github.retronym.SbtOneJar._

name := "elastic"

version := "1.0"

oneJarSettings

libraryDependencies += "com.sksamuel.elastic4s" %% "elastic4s" % "1.1.0.0"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
