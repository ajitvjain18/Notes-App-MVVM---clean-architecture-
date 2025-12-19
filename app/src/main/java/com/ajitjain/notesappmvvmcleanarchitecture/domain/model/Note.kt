package com.ajitjain.notesappmvvmcleanarchitecture.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity
data class Note(
    @PrimaryKey val id: Int?= null,
    val title: String,
    val content : String,
    val timestamp: Long
)
