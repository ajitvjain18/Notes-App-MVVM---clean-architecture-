package com.ajitjain.notesappmvvmcleanarchitecture.di

import android.app.Application
import androidx.room.Room
import com.ajitjain.notesappmvvmcleanarchitecture.NoteApp
import com.ajitjain.notesappmvvmcleanarchitecture.data.data_source.NoteDatabase
import com.ajitjain.notesappmvvmcleanarchitecture.data.repository.NoteRepositoryImpl
import com.ajitjain.notesappmvvmcleanarchitecture.domain.repository.NoteRepository
import com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case.DeleteNoteUseCase
import com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case.GetNoteByIdUseCase
import com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case.GetNotesUseCase
import com.ajitjain.notesappmvvmcleanarchitecture.domain.use_case.InsertNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, NoteDatabase.DATABASENAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideGetNotesUseCases(repository: NoteRepository): GetNotesUseCase {
        return GetNotesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetNoteByIdUseCases(repository: NoteRepository): GetNoteByIdUseCase {
        return GetNoteByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteNoteCase(repository: NoteRepository): DeleteNoteUseCase {
        return DeleteNoteUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideInsertNodeUseCase(repository: NoteRepository): InsertNoteUseCase {
        return InsertNoteUseCase(repository)
    }

}