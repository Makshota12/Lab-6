package com.example.lab6.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab6.model.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "lab6-db"
            ).build()
        }
    }
}