package com.example.to_docompose.usecases

import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.database.dao.TransactionDao
import javax.inject.Inject

class SortTasksByLowPriorityUseCase @Inject constructor(
    private val transactionDao: TransactionDao
) {
    operator fun invoke(): List<ToDoTask> {
        return transactionDao.sortByLowPriority()
    }
}