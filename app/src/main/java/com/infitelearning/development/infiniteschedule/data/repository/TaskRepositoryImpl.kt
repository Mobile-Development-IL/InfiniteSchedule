package com.infitelearning.development.infiniteschedule.data.repository

import com.infitelearning.development.infiniteschedule.data.local.LocalDataSource
import com.infitelearning.development.infiniteschedule.data.local.entity.TaskEntity
import com.infitelearning.development.infiniteschedule.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl private constructor(
    private val localDataSource: LocalDataSource
): TaskRepository {

    companion object {
        @Volatile
        private var instance: TaskRepositoryImpl? = null

        fun getInstance(
            localData: LocalDataSource,
        ): TaskRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: TaskRepositoryImpl(localData)
            }
    }

    override suspend fun upsertTask(taskEntity: TaskEntity) = localDataSource.upsertTask(taskEntity)

    override suspend fun deleteTask(taskId: Int) = localDataSource.deleteTaskById(taskId)

    override fun getTaskById(taskId: Int): Flow<TaskEntity?> = localDataSource.getTaskById(taskId)

    override fun getAllTasks(): Flow<List<TaskEntity>> = localDataSource.getAllTasks()
}