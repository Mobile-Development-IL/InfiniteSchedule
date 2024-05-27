package com.infitelearning.development.infiniteschedule.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.infitelearning.development.infiniteschedule.data.local.room.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTaskDatabase(@ApplicationContext context: Context): TaskDatabase {
        return Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "db_task"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(taskDatabase: TaskDatabase) = taskDatabase.taskDao()
}