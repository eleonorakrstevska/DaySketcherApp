package com.example.daysketcher

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: JournalEntry)

    @Query("SELECT * FROM journal_entries ORDER BY date DESC")
    fun getAllEntries(): Flow<List<JournalEntry>>
}
