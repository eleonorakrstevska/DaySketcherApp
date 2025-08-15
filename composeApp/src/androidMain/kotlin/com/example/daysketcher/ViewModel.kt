package com.example.daysketcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class JournalViewModel(private val dao: JournalDao) : ViewModel() {

    val entries = dao.getAllEntries()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addEntry(title: String, emotion: String, content: String, type: String) {
        viewModelScope.launch {
            dao.insertEntry(
                JournalEntry(
                    title = title,
                    emotion = emotion,
                    content = content,
                    date = java.util.Date(),
                    type = type
                )
            )
        }
    }
}
