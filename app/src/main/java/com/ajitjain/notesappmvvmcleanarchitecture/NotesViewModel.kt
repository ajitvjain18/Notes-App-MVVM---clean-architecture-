package com.ajitjain.notesappmvvmcleanarchitecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajitjain.notesappmvvmcleanarchitecture.domain.model.Note
import com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case.DeleteNoteUseCase
import com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case.GetNoteByIdUseCase
import com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case.GetNotesUseCase
import com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val insertNoteUseCase: InsertNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes : StateFlow<List<Note>> = _notes.asStateFlow()

    private val _selectedNote = MutableStateFlow<Note?>(null)
    val selectedNote = _selectedNote.asStateFlow()

    init {
        fetchNotes()
    }

    private fun fetchNotes() {
        viewModelScope.launch {
            getNotesUseCase().collect {
                _notes.value = it
            }
        }
    }

    fun getNoteById(id: Int) {
        viewModelScope.launch {
            _selectedNote.value = getNoteByIdUseCase(id)
        }
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            insertNoteUseCase(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
        }
    }


}