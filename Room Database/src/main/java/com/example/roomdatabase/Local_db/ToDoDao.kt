package com.example.roomdatabase.Local_db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun insert(task: ToDoEntity)

    @Delete
    suspend fun delete(task: ToDoEntity)

    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllTasks(): LiveData<List<ToDoEntity>>
}