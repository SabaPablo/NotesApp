package com.doce.cactus.saba.jetnote.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.doce.cactus.saba.jetnote.data.NotesDataSource
import com.doce.cactus.saba.jetnote.model.Note

class NoteViewModel: ViewModel() {
    var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note:Note){
        noteList.add(note)
    }

    fun removeNote(note:Note){
        noteList.remove(note)

    }

    fun getAllNotes():List<Note>{
        return noteList
    }
}