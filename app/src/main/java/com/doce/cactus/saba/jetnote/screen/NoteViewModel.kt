package com.doce.cactus.saba.jetnote.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doce.cactus.saba.jetnote.data.NotesDataSource
import com.doce.cactus.saba.jetnote.model.Note
import com.doce.cactus.saba.jetnote.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {
    //var noteList = mutableStateListOf<Note>()

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList: StateFlow<List<Note>> = _noteList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect{ listOfNotes ->
                    _noteList.value = listOfNotes
                }
        }
    }

    fun addNote(note:Note) = viewModelScope.launch{ repository.addNote(note)}
    fun updateNote(note:Note) = viewModelScope.launch{ repository.updateNote(note)}
    fun removeNote(note:Note) = viewModelScope.launch{ repository.deleteNote(note)}

}