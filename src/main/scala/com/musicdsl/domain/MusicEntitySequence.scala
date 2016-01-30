package com.musicdsl.domain

/**
  * The helper object for the implicit class.
  */
object MusicEntitySequence {

  /**
    * The implicit class which enables you to call methods like `octaveUp` on a normal List of `MusicEntity`.
    * @param entities The list of entities.
    */
  implicit class MusicEntitySequence(entities: List[MusicEntity]) {
    def during(durations: Duration*): List[MusicEntity] =
      entities.map(entity => entity.durations match {
        case Seq(Default) => entity.during(durations: _*)
        case _ => entity
      })

    def octaveUp = entities.map(_.octaveUp)
    def octaveDown = entities.map(_.octaveDown)

    def repeat = entities ::: entities
  }
}
