package com.example.homework_22.domain

interface NoteRepository {
    fun getNotes(): List<NoteModel>
    fun addNote(note: NoteModel)
    fun deleteNote(noteId: Long)
}