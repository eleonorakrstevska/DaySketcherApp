package com.example.daysketcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class JournalViewModelFactory(private val dao: JournalDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JournalViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return JournalViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
