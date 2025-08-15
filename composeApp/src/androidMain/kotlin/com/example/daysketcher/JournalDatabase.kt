package com.example.daysketcher

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [JournalEntry::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class JournalDatabase : RoomDatabase() {
    abstract fun journalDao(): JournalDao

    companion object {
        @Volatile
        private var INSTANCE: JournalDatabase? = null

        fun getDatabase(context: Context): JournalDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    JournalDatabase::class.java,
                    "journal_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
