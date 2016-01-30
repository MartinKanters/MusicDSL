package com.musicdsl.midi

import java.io.File
import javax.sound.midi._

import com.musicdsl.domain.MusicEntitySequence.MusicEntitySequence
import com.musicdsl.domain._
import com.sun.media.sound.StandardMidiFileWriter

/**
  * Can turn a list of `MusicEntity` objects into Midi.
  * Basically an example of a user of the musicDSL library.
  */
object MidiMusicEntitySequence {

  /**
    * Pimping a List of `MusicEntity` objects so that one can create Midi files out of it or play it directly.
    * @param entities The list of entities.
    */
  implicit class MidiMusicEntitySequence(entities: List[MusicEntity]) extends MusicEntitySequence(entities: List[MusicEntity]) {
    private val midiCorrection: Int = 6

    type TimedMidiEvent = (Int, Option[MidiEvent])

    /**
      * Creates a MidiSequence out of the List of `MusicEntity` objects.
      * @return An instance of [[javax.sound.midi.Sequence]] wrapped in a MidiSequence
      */
    def toMidi: MidiSequence = {
      import ShortMessage._
      val sequence = new Sequence(Sequence.PPQ, 24)
      val track = sequence.createTrack()
      val times = entities.map(_.durations.scanLeft(0) {
        case (ticks, Eighth) => ticks +  12
        case (ticks, Quarter) => ticks + 24
        case (ticks, Default) => ticks + 24
        case (ticks, Half) => ticks +    24 * 2
        case (ticks, Whole) => ticks +   24 * 4
      }.last)

      times.zip(entities)
        .flatMap { tuple: (Int, MusicEntity) =>
          val (duration, entity) = tuple

          entity match {
            case note: Note =>
              val midiHeight = note.height.getOrElse(Height())
              val (relative, octave, baseNote) = extractHeight(midiHeight)

              val height = midiCorrection + (baseNote + relative) + (octave * 12)

                (0,        Some(new ShortMessage(NOTE_ON, 0, height, 100))) ::
                (duration, Some(new ShortMessage(NOTE_OFF, 0, height, 0))) ::
                Nil
            case rest: Rest =>
              List((duration, None))
          }
        }
        .scanLeft[TimedMidiEvent, List[TimedMidiEvent]]((0, None)) {
        case (lastEvent, (duration, message: Some[ShortMessage])) =>
          val offset = lastEvent._1
          val shortMessage = message.get

          shortMessage.getCommand match {
            case NOTE_ON =>
              (offset, Some(new MidiEvent(shortMessage, offset)))
            case NOTE_OFF =>
              val newOffset = offset + duration
              (newOffset, Some(new MidiEvent(shortMessage, newOffset)))
          }
        case (lastEvent, (duration, None)) =>
          val newOffset: Int = lastEvent._1 + duration
          (newOffset, None)
      }
        .map(_._2)
        .filter(_.isDefined)
        .map(_.get)
        .foreach(track.add)

      new MidiSequence(sequence)
    }

    private def extractHeight(midiHeight: Height): (Int, Int, Int) = {
      val relative = midiHeight.relative.getOrElse(0)
      val octave = midiHeight.octave.getOrElse(4)
      val baseNote = midiHeight.baseNote.getOrElse(3)
      (relative, octave, baseNote)
    }
  }

  /**
    * A MidiSequence which enables you to write the [[javax.sound.midi.Sequence]] to a file or play it.
    * @param sequence The [[javax.sound.midi.Sequence]] object.
    */
  class MidiSequence(sequence: Sequence) {
    def writeFile(filename: String = "target/test.mid") = {
      val file = new File(filename)
      new StandardMidiFileWriter().write(sequence, 0, file)
      file.toPath
    }

    def play() = {
      val sequencer = MidiSystem.getSequencer
      sequencer.open()
      sequencer.setSequence(sequence)
      sequencer.start()
    }
  }
}