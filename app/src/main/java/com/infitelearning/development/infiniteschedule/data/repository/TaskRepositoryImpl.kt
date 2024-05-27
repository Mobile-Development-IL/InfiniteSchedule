package com.infitelearning.development.infiniteschedule.data.repository

import com.infitelearning.development.infiniteschedule.data.local.LocalDataSource
import com.infitelearning.development.infiniteschedule.data.local.entity.TaskEntity
import com.infitelearning.development.infiniteschedule.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : TaskRepository {

    override suspend fun upsertTask(taskEntity: TaskEntity) = localDataSource.upsertTask(taskEntity)

    override suspend fun deleteTask(taskId: Int) = localDataSource.deleteTaskById(taskId)

    override fun getTaskById(taskId: Int): Flow<TaskEntity?> = localDataSource.getTaskById(taskId)

    override fun getAllTasks(): Flow<List<TaskEntity>> = localDataSource.getAllTasks()
}