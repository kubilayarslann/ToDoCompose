package com.example.to_docompose.di

import android.content.Context
import com.example.to_docompose.database.ToDoTasksDAO
import com.example.to_docompose.database.ToDoDatabase
import com.example.to_docompose.database.dao.TransactionDao
import com.example.to_docompose.database.dao.TransactionDaoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatabaseModule {

    companion object {
        @Provides
        fun provideToDoDao(appDatabase: ToDoDatabase): ToDoTasksDAO {
            return appDatabase.toDoDao()
        }

        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext appContext: Context): ToDoDatabase {
            return ToDoDatabase.create(appContext)
        }
    }

    @Binds
    fun bindTransactionDao(impl: TransactionDaoImpl): TransactionDao
}