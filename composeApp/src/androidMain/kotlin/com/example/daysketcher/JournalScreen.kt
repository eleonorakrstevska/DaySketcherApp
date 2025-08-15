package com.example.daysketcher

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items


@Composable
fun JournalScreen(viewModel: JournalViewModel) {

    val entries by viewModel.entries.collectAsState()

    LazyColumn {
        items(entries) { entry ->
            JournalCard(entry)
        }
    }
}
