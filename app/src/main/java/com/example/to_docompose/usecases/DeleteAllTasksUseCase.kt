package com.example.to_docompose.usecases

import com.example.to_docompose.database.dao.TransactionDao
import javax.inject.Inject

class DeleteAllTasksUseCase @Inject constructor(
    private val transactionDao: TransactionDao
) {
    suspend operator fun invoke() {
        transactionDao.deleteAllTasks()
    }
}