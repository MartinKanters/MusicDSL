package com.musicdsl.domain

/**
  * Possible durations of `MusicEntity` objects are shown here.
  *
  * When using `Default` it is up to the user of the DSL what it should take.
  */
sealed trait Duration
object Whole extends Duration
object Half extends Duration
object Quarter extends Duration
object Eighth extends Duration
object Default extends Duration

