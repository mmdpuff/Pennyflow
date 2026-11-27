package com.mmdpuff.pennyflow.core.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("select * from note")
    fun getAllNote(): Flow<List<Note>>
}