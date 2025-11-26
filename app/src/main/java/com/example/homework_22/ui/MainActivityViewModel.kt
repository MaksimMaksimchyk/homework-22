package com.example.homework_22.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework_22.data.LocalNoteDataSource
import com.example.homework_22.data.NoteRepositoryImpl
import com.example.homework_22.domain.NoteInteractor
import com.example.homework_22.domain.NoteModel

class MainActivityViewModel : ViewModel() {

    private val noteInteractor: NoteInteractor by lazy {
        val dataSource = LocalNoteDataSource()
        val repository = NoteRepositoryImpl(dataSource)
        NoteInteractor(repository)
    }

    private val _notes = MutableLiveData<List<NoteModel>>()
    val notes: LiveData<List<NoteModel>> = _notes

    init {
        loadNotes()
    }

    fun loadNotes() {
        val notesList = noteInteractor.getNotes()
        _notes.value = notesList
    }

    fun addNote(content: String) {
        if (content.isBlank()) return
        noteInteractor.addNote(content)
        loadNotes()
    }

    fun deleteNote(note: NoteModel) {
        noteInteractor.deleteNote(note.id)
        loadNotes()
    }

}