package com.example.to_docompose.usecases

import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.database.dao.TransactionDao
import javax.inject.Inject

class GetSelectedTaskUseCase @Inject constructor(
    private val transactionDao: TransactionDao
) {
    operator fun invoke(selectedTaskId: Int): ToDoTask {
        return transactionDao.getSelectedTask(taskId = selectedTaskId)
    }
}