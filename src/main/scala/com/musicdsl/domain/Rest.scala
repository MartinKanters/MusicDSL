package com.musicdsl.domain

/**
  * A Rest which contains a duration where it does nothing.
  * @param durations A list of duration objects, which makes it possible to combine certain durations (Half + Quarter).
  */
case class Rest(durations: Seq[Duration] = Seq(Default)) extends MusicEntity {
  val height = None

  override def during(durations: Duration*) = this.copy(durations = durations)

  override def octaveUp = this
  override def octaveDown = this

  override def repeat = this :: this.copy() :: Nil
}
