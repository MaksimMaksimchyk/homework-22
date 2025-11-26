package com.example.homework_22.data

import com.example.homework_22.domain.NoteModel
import com.example.homework_22.domain.NoteRepository

class NoteRepositoryImpl(
    private val localDataSource: LocalNoteDataSource
) : NoteRepository {

    override fun getNotes(): List<NoteModel> {
        return localDataSource.getNotes()
    }

    override fun addNote(note: NoteModel) {
        localDataSource.addNote(note)
    }
}