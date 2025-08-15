package com.example.daysketcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = JournalDatabase.getDatabase(applicationContext)
        val dao = db.journalDao()
        val viewModelFactory = JournalViewModelFactory(dao)

        setContent {
            MaterialTheme {
                var userName by remember { mutableStateOf<String?>(null) }

                val viewModel: JournalViewModel = viewModel(factory = viewModelFactory)

                Surface {
                    if (userName == null) {
                        EnterNameScreen { enteredName ->
                            userName = enteredName
                        }
                    } else {
                        MainScreen(userName!!, viewModel)
                    }
                }
            }
        }
    }
}

