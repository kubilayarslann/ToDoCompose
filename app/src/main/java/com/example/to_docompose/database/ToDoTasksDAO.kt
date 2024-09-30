package com.example.to_docompose.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.to_docompose.data.models.ToDoTask

@Dao
interface ToDoTasksDAO {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): List<ToDoTask>

    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): ToDoTask

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchKey OR description LIKE :searchKey")
    fun searchDatabase(searchKey: String): List<ToDoTask>

    @Query(
        "SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority " +
            "LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END "
    )
    fun sortByLowPriority(): List<ToDoTask>

    @Query(
        "SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority " +
            "LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END "
    )
    fun sortByHighPriority(): List<ToDoTask>
}