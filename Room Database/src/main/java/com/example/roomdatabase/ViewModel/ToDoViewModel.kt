package com.example.roomdatabase.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.Local_db.ToDoDatabase
import com.example.roomdatabase.Local_db.ToDoEntity
import com.example.roomdatabase.Repository.ToDoRepository
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ToDoRepository

    val allTasks: LiveData<List<ToDoEntity>>

    init {
        val dao = ToDoDatabase.getDatabase(application).todoDao()
        repository = ToDoRepository(dao)
        allTasks = repository.allTasks
    }

    fun insert(task: ToDoEntity) = viewModelScope.launch {
        repository.insert(task)
    }

    fun delete(task: ToDoEntity) = viewModelScope.launch {
        repository.delete(task)
    }
}
