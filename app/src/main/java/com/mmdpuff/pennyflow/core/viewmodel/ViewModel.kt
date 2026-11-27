package com.mmdpuff.pennyflow.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mmdpuff.pennyflow.core.room.Note
import kotlinx.coroutines.launch

class ViewModel(private val repository: Repository) : ViewModel() {
    fun getNotes() = repository.getNote().asLiveData(viewModelScope.coroutineContext)

    fun insert(note: Note) {
        viewModelScope.launch {
            repository.insert(note)
        }
    }
}