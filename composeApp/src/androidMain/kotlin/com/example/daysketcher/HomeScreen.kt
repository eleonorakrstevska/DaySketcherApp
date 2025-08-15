package com.example.daysketcher

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.*
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(userName: String,
               viewModel: JournalViewModel,
               navController: NavHostController) {
    val greeting = getGreeting()
    var showDialog by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    val entries by viewModel.entries.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // Greeting + Plus Button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$greeting, $userName!",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search for memory") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (showDialog) {
            WritingOptionsDialog(
                onDismiss = { showDialog = false },
                onStartWriting = { selectedOption ->
//                    println("Selected: $selectedOption")
                    showDialog = false
                    when (selectedOption) {
                        "Emotion" -> navController.navigate("emotionEntry")

                        // for later
                        "Memory" -> navController.navigate("memoryEntry")
                        "Journal" -> navController.navigate("journalEntry")
                    }
                }
            )
        }

        LazyColumn {
            items(entries) { entry ->
                JournalCard(entry)
            }
        }
    }
}


@Composable
fun JournalCard(entry: JournalEntry) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = entry.type, style = MaterialTheme.typography.labelSmall)
            Text(text = entry.title, style = MaterialTheme.typography.titleMedium)
            Text(text = "I felt ${entry.emotion}", style = MaterialTheme.typography.bodySmall)
            Text(
                text = entry.content.split(".").take(3).joinToString(". ") + ".",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(text = entry.date.toString(), style = MaterialTheme.typography.labelSmall)
        }
    }
}



fun getGreeting(): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 5..11 -> "Good morning"
        in 12..17 -> "Good afternoon"
        in 18..21 -> "Good evening"
        else -> "Hello"
    }
}
