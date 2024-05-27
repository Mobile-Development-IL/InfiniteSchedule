package com.infitelearning.development.infiniteschedule.di

import com.infitelearning.development.infiniteschedule.data.repository.TaskRepositoryImpl
import com.infitelearning.development.infiniteschedule.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideTaskRepository(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository
}