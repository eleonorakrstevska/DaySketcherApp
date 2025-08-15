package com.example.daysketcher

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "journal_entries")
data class JournalEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val emotion: String,
    val content: String,
    val date: Date,
    val type: String // "Emotion" или "Today's Mood"
)
