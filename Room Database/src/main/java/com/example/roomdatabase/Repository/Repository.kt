package com.example.roomdatabase.Repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase.Local_db.ToDoDao
import com.example.roomdatabase.Local_db.ToDoEntity

// ToDoRepository.kt
class ToDoRepository(private val dao: ToDoDao) {
    val allTasks: LiveData<List<ToDoEntity>> = dao.getAllTasks()

    suspend fun insert(task: ToDoEntity) {
        dao.insert(task)
    }

    suspend fun delete(task: ToDoEntity) {
        dao.delete(task)
    }
}
