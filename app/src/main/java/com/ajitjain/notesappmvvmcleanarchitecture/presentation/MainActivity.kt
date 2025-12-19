package com.ajitjain.notesappmvvmcleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajitjain.notesappmvvmcleanarchitecture.NotesViewModel
import com.ajitjain.notesappmvvmcleanarchitecture.ui.theme.NotesAppMVVMCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppMVVMCleanArchitectureTheme {
                val viewModel: NotesViewModel = hiltViewModel()
                NotesScreen(viewModel)
            }
        }
    }

    @Composable
    fun NotesScreen(
        viewModel: NotesViewModel
    ) {
        val notes by viewModel.notes.collectAsState()
        Log.d("ajit",notes.size.toString())
        LazyColumn {
            items(notes) { note ->
                Text(text = note.title)
            }
        }
    }
}
