# MusicDSL
A very early version of a library written in Scala for easily creating notes, melodies and even whole songs!

The idea behind this project is that we can use the flexible features of Scala to create a compact, but readable DSL for creating music.

You can find some working examples in https://github.com/MartinKanters/MusicDSL/blob/master/src/main/scala/com/musicdsl/application/Application.scala.

## Midi
Right now there is a way to play these melodies by Midi using the ancient javax.sound.midi package. 
This is meant as an example for a user of the MusicDSL library. In the future I will probably move it to a different project, leaving only the DSL kind of stuff in here.

You can play the melodies from the Application class simply by executing `sbt run`.
