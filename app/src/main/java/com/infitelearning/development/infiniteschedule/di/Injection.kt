package com.dicoding.tourismapp.core.di

import android.content.Context
import com.infitelearning.development.infiniteschedule.data.local.LocalDataSource
import com.infitelearning.development.infiniteschedule.data.local.room.TaskDatabase
import com.infitelearning.development.infiniteschedule.data.repository.TaskRepositoryImpl
import com.infitelearning.development.infiniteschedule.domain.repository.TaskRepository

object Injection {
    fun provideRepository(context: Context): TaskRepository {
        val database = TaskDatabase.getInstance(context)

        val localDataSource = LocalDataSource.getInstance(database.taskDao())

        return TaskRepositoryImpl.getInstance(localDataSource)
    }
}
