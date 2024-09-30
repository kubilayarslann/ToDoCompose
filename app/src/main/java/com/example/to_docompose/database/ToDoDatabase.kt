package com.example.to_docompose.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.database.ToDoDatabase.Companion.LATEST_VERSION
import com.example.to_docompose.utils.Constants.DATABASE_NAME

@Database(entities = [ToDoTask::class], version = LATEST_VERSION, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoTasksDAO

    companion object {
        const val LATEST_VERSION = 1

        @Suppress("SpreadOperator")
        fun create(context: Context): ToDoDatabase {
            return Room.databaseBuilder(
                context = context,
                klass = ToDoDatabase::class.java,
                name = DATABASE_NAME
            )
                .build()
        }

    }
}