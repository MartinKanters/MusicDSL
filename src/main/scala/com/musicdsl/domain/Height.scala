package com.musicdsl.domain

/**
  * Indicating the note-height of a `MusicEntity`.
  *
  * This height class is meant to be made flexible and thus not define a static height.
  * For example, one can create a `Height` for a C4 by using relative(3) and octave(4)
  * and then transpose it to a D4 by setting `baseNote` to two.
  * @param relative The note relative to the `baseNote`. If 0 would be A, 1 would be A# and 3 would be C.
  * @param octave The octave of the note.
  * @param baseNote The base height where the `relative` attribute is relative to.
  *                 Useful for transposing.
  *                 If relative 0 would be an A with a baseNote of 0, it should be a C with baseNote 3.
  */
case class Height(relative: Option[Int] = None,
                  octave: Option[Int] = None,
                  baseNote: Option[Int] = None) {
  private val defOctave = 4

  def octaveUp: Height = this.copy(octave = Some(octave.getOrElse(defOctave) + 1))
  def octaveDown: Height = this.copy(octave = Some(octave.getOrElse(defOctave) - 1))
}
