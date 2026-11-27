package com.mmdpuff.pennyflow.core.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
