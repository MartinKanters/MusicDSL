package com.musicdsl.domain

/**
  * A note containing the duration length and the height.
  * @param durations A list of duration objects, which makes it possible to combine certain durations (Half + Quarter).
  * @param height The height of the `Note`.
  */
case class Note(durations: Seq[Duration] = Seq(Default),
                height: Option[Height] = None) extends MusicEntity {
  override def during(durations: Duration*) = this.copy(durations = durations)

  override def octaveUp = height match {
    case Some(h) => this.copy(height = Some(h.octaveUp))
    case None => this
  }

  override def octaveDown = height match {
    case Some(h) => this.copy(height = Some(h.octaveDown))
    case None => this
  }

  override def repeat = this :: this.copy() :: Nil
}
