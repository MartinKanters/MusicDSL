package com.musicdsl.factory

import com.musicdsl.domain.{Height, Note}

/**
  * Contains methods for creating `Note` objects in a compact way.
  */
object NoteFactory {
  def A    = new Note(height = Some(Height(Some(0))))
  def Ais  = new Note(height = Some(Height(Some(1))))
  def B    = new Note(height = Some(Height(Some(2))))
  def C    = new Note(height = Some(Height(Some(3))))
  def Cis  = new Note(height = Some(Height(Some(4))))
  def D    = new Note(height = Some(Height(Some(5))))
  def Dis  = new Note(height = Some(Height(Some(6))))
  def E    = new Note(height = Some(Height(Some(7))))
  def F    = new Note(height = Some(Height(Some(8))))
  def Fis  = new Note(height = Some(Height(Some(9))))
  def G    = new Note(height = Some(Height(Some(10))))
  def Gis  = new Note(height = Some(Height(Some(11))))

  def A4    = new Note(height = Some(Height(Some(0),  Some(4))))
  def Ais4  = new Note(height = Some(Height(Some(1),  Some(4))))
  def B4    = new Note(height = Some(Height(Some(2),  Some(4))))
  def C4    = new Note(height = Some(Height(Some(3),  Some(4))))
  def Cis4  = new Note(height = Some(Height(Some(4),  Some(4))))
  def D4    = new Note(height = Some(Height(Some(5),  Some(4))))
  def Dis4  = new Note(height = Some(Height(Some(6),  Some(4))))
  def E4    = new Note(height = Some(Height(Some(7),  Some(4))))
  def F4    = new Note(height = Some(Height(Some(8),  Some(4))))
  def Fis4  = new Note(height = Some(Height(Some(9),  Some(4))))
  def G4    = new Note(height = Some(Height(Some(10), Some(4))))
  def Gis4  = new Note(height = Some(Height(Some(11), Some(4))))

  def A5    = new Note(height = Some(Height(Some(0),  Some(5))))
  def Ais5  = new Note(height = Some(Height(Some(1),  Some(5))))
  def B5    = new Note(height = Some(Height(Some(2),  Some(5))))
  def C5    = new Note(height = Some(Height(Some(3),  Some(5))))
  def Cis5  = new Note(height = Some(Height(Some(4),  Some(5))))
  def D5    = new Note(height = Some(Height(Some(5),  Some(5))))
  def Dis5  = new Note(height = Some(Height(Some(6),  Some(5))))
  def E5    = new Note(height = Some(Height(Some(7),  Some(5))))
  def F5    = new Note(height = Some(Height(Some(8),  Some(5))))
  def Fis5  = new Note(height = Some(Height(Some(9),  Some(5))))
  def G5    = new Note(height = Some(Height(Some(10), Some(5))))
  def Gis5  = new Note(height = Some(Height(Some(11), Some(5))))
}
