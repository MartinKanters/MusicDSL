package com.musicdsl.domain

/**
  * Abstract class for single musical units like a `Note` or a `Rest`.
  */
abstract class MusicEntity {
  val durations: Seq[Duration]
  val height: Option[Height]

  def during(durations: Duration*): MusicEntity

  def octaveUp: MusicEntity
  def octaveDown: MusicEntity

  def repeat: List[MusicEntity]
}
