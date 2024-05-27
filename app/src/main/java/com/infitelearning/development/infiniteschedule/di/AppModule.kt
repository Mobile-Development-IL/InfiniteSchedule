package com.infitelearning.development.infiniteschedule.di

import com.infitelearning.development.infiniteschedule.domain.usecase.TaskUseCase
import com.infitelearning.development.infiniteschedule.domain.usecase.TaskUseCaseInteract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindRepository(taskUseCaseInteract: TaskUseCaseInteract): TaskUseCase
}