package com.example.to_docompose.ui.presentation.screens.taskslist.model

import com.example.to_docompose.data.models.ToDoTask

data class ListState(
    val tasksList: List<ToDoTask> = emptyList()
)