package com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case

import com.ajitjain.notesappmvvmcleanarchitecture.domain.model.Note
import com.ajitjain.notesappmvvmcleanarchitecture.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(private val repository: NoteRepository) {

    operator fun invoke(): Flow<List<Note>> {
        return repository.getNotes()
    }

}