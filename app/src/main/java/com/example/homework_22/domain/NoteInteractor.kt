package com.example.homework_22.domain

class NoteInteractor(
    private val noteRepository: NoteRepository
) {

    fun getNotes(): List<NoteModel> = noteRepository.getNotes()

    fun addNote(content: String) {
        val note = NoteModel(content = content)
        noteRepository.addNote(note)
    }

    fun deleteNote(noteId: Long) {
        noteRepository.deleteNote(noteId)
    }

}