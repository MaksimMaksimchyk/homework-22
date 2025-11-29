package com.example.homework_22.data

import com.example.homework_22.domain.NoteModel

class LocalNoteDataSource {
    private val notes = mutableListOf<NoteModel>()
    fun getNotes(): List<NoteModel> = notes.toList()

    fun addNote(note: NoteModel) {
        notes.add(0, note)
    }
    fun deleteNote(noteId: Long) {
        notes.remove(notes.find { it.id == noteId })
    }
}