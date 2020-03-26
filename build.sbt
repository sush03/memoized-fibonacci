name := "memoization-scala"

version := "0.1"

scalaVersion := "2.13.1"
libraryDependencies +="com.github.cb372" %% "scalacache-caffeine" % "0.28.0"
libraryDependencies += "com.github.cb372" %% "scalacache-memcached" % "0.28.0"
libraryDependencies += "org.scalatest" % "scalatest_2.13" % "3.1.1" % "test"
