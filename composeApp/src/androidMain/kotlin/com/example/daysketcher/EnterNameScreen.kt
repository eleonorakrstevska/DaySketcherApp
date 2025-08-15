package com.example.daysketcher

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EnterNameScreen(onNameEntered: (String) -> Unit) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Please enter your name:", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { if (name.isNotBlank()) onNameEntered(name) },
            enabled = name.isNotBlank()
        ) {
            Text("Start")
        }
    }
}
