package com.ajitjain.notesappmvvmcleanarchitecture.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ajitjain.notesappmvvmcleanarchitecture.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object{
        val DATABASENAME = "notes_db"
    }
}