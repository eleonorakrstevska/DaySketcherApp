package com.example.daysketcher

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmotionEntryScreen(
    viewModel: JournalViewModel = viewModel(),
    onBack: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var selectedEmotion by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    val emotions = listOf("Amazing", "Happy", "Neutral", "Angry", "Sad", "Anxious", "I don't know")

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Title field
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        // Emotions selection
        Text("Right now I feel:")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            emotions.forEach { emotion ->
                FilterChip(
                    selected = selectedEmotion == emotion,
                    onClick = { selectedEmotion = emotion },
                    label = { Text(emotion) }
                )
            }
        }

        // Content field
        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Save button
        Button(onClick = {
            if (title.isNotBlank() && selectedEmotion.isNotBlank() && content.isNotBlank()) {
                viewModel.addEntry(title, selectedEmotion, content, "Emotion")
                onBack()
            }
        }) {
            Text("Save entry")
        }
    }
}


