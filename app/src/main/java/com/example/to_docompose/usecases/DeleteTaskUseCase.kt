package com.example.to_docompose.usecases

import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.database.dao.TransactionDao
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val transactionDao: TransactionDao
) {
    suspend operator fun invoke(toDoTask: ToDoTask) {
        transactionDao.deleteTask(toDoTask = toDoTask)
    }
}