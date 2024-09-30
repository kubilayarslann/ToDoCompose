package com.example.to_docompose.database.dao

import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.database.ToDoTasksDAO
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

class TransactionDaoImpl @Inject constructor(private val toDoTasksDao: ToDoTasksDAO) : TransactionDao {

    // TODO: This variables must be defined in view models.
/*    val getAllTask: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()*/

    override fun getAllTasks(): List<ToDoTask> {
        return toDoTasksDao.getAllTasks()
    }

    override fun sortByLowPriority(): List<ToDoTask> {
        return toDoTasksDao.sortByLowPriority()
    }

    override fun sortByHighPriority(): List<ToDoTask> {
        return toDoTasksDao.sortByHighPriority()
    }

    override fun getSelectedTask(taskId: Int): ToDoTask {
        return toDoTasksDao.getSelectedTask(taskId = taskId)
    }

    override suspend fun addTask(toDoTask: ToDoTask) {
        toDoTasksDao.addTask(toDoTask = toDoTask)
    }

    override suspend fun updateTask(toDoTask: ToDoTask) {
        toDoTasksDao.updateTask(toDoTask = toDoTask)
    }

    override suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoTasksDao.deleteTask(toDoTask = toDoTask)
    }

    override suspend fun deleteAllTasks() {
        toDoTasksDao.deleteAllTasks()
    }

    override fun searchDatabase(searchQuery: String): List<ToDoTask> {
        return toDoTasksDao.searchDatabase(searchKey = searchQuery)
    }
}