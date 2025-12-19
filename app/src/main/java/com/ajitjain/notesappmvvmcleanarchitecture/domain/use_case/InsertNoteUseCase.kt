package com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case

import com.ajitjain.notesappmvvmcleanarchitecture.domain.model.Note
import com.ajitjain.notesappmvvmcleanarchitecture.domain.repository.NoteRepository

class InsertNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.insertNote(note)
    }
}