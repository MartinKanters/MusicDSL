package com.musicdsl.factory

import com.musicdsl.domain.Rest

/**
  * Contains methods for creating `Rest` objects in a compact way
  */
object RestFactory {
  def Rest = new Rest()
}
