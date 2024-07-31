package com.example.to_docompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.to_docompose.utils.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
