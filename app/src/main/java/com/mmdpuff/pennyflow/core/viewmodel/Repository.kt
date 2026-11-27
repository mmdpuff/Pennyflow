package com.mmdpuff.pennyflow.core.viewmodel

import com.mmdpuff.pennyflow.core.room.Note
import com.mmdpuff.pennyflow.core.room.NoteDatabase

class Repository(private val db: NoteDatabase) {
    suspend fun insert(note: Note) {
        db.dao.insert(note)
    }

    fun getNote() = db.dao.getAllNote()

}