package com.example.lab6.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.lab6.model.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Query("SELECT * FROM persons")
    fun getAll(): Flow<List<PersonEntity>>

    @Insert
    suspend fun insert(person: PersonEntity)

    @Update
    suspend fun update(person: PersonEntity)

    @Delete
    suspend fun delete(person: PersonEntity)
}