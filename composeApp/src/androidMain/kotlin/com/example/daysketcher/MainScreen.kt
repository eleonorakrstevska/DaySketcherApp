package com.example.daysketcher

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen(userName: String,
               viewModel: JournalViewModel = viewModel()) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") { HomeScreen(userName, viewModel, navController) }

            composable("journal") { JournalScreen(viewModel = viewModel) }
            composable("memories") { MemoriesScreen() }
            composable("settings") { SettingsScreen() }

            composable("emotionEntry") {
                EmotionEntryScreen(
                    viewModel = viewModel,
                    onBack = { navController.popBackStack() }
                )
            }
//            composable("memoryEntry") {
//                MemoryEntryScreen(
//                    viewModel = viewModel,
//                    onBack = { navController.popBackStack() }
//                )
//            }
//            composable("journalEntry") {
//                JournalEntryScreen(
//                    viewModel = viewModel,
//                    onBack = { navController.popBackStack() }
//                )
//            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("home") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Book, contentDescription = "Journal") },
            label = { Text("Journal") },
            selected = false,
            onClick = { navController.navigate("journal") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Photo, contentDescription = "Memories") },
            label = { Text("Memories") },
            selected = false,
            onClick = { navController.navigate("memories") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = false,
            onClick = { navController.navigate("settings") }
        )
    }
}
