name := "MusicDSL"
version := "1.0"

scalaVersion := "2.11.7"

mainClass in (Compile, run) := Some("com.musicdsl.application.Application")

// Forking causes the application to run in a separate JVM which fixes the problem of finding Midi Devices
fork in run := true
connectInput in run := true