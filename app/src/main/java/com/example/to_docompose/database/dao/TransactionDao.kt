package com.example.to_docompose.database.dao

import com.example.to_docompose.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

interface TransactionDao {

    fun getAllTasks(): List<ToDoTask>

    fun sortByLowPriority(): List<ToDoTask>

    fun sortByHighPriority(): List<ToDoTask>

    fun getSelectedTask(taskId: Int): ToDoTask

    suspend fun addTask(toDoTask: ToDoTask)

    suspend fun updateTask(toDoTask: ToDoTask)

    suspend fun deleteTask(toDoTask: ToDoTask)

    suspend fun deleteAllTasks()

    fun searchDatabase(searchQuery: String): List<ToDoTask>
}