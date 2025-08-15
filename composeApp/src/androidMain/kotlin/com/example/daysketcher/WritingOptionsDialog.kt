package com.example.daysketcher

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun WritingOptionsDialog(
    onDismiss: () -> Unit,
    onStartWriting: (String) -> Unit
) {
    var selectedOption by remember { mutableStateOf<String?>(null) }
    val options = listOf(
        "Emotion" to "How do you feel right now?",
        "Mood" to "How did you feel overall today?",
        "Template" to "Who or what inspires you the most and how does it influence your aspirations and creativity?"
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Start writing about") },
        text = {
            Column {
                options.forEach { (title, description) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedOption == title,
                                onClick = { selectedOption = title },
                                role = Role.RadioButton
                            )
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOption == title,
                            onClick = { selectedOption = title }
                        )
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(title, style = MaterialTheme.typography.bodySmall)
                            Text(description, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = { selectedOption?.let { onStartWriting(it) } },
                enabled = selectedOption != null
            ) {
                Text("Start Writing")
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
