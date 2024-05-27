package com.infitelearning.development.infiniteschedule.data.repository

import com.infitelearning.development.infiniteschedule.data.local.LocalDataSource
import com.infitelearning.development.infiniteschedule.domain.model.Task
import com.infitelearning.development.infiniteschedule.domain.repository.TaskRepository
import com.infitelearning.development.infiniteschedule.utils.DataMapper.mapDomainToEntity
import com.infitelearning.development.infiniteschedule.utils.DataMapper.mapEntitiesToDomain
import com.infitelearning.development.infiniteschedule.utils.DataMapper.mapEntityToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : TaskRepository {

    override suspend fun upsertTask(task: Task) =
        localDataSource.upsertTask(mapDomainToEntity(task))

    override suspend fun deleteTask(taskId: Int) = localDataSource.deleteTaskById(taskId)

    override fun getTaskById(taskId: Int): Flow<Task?> = localDataSource.getTaskById(taskId).map {
        mapEntityToDomain(it ?: return@map null)
    }

    override fun getAllTasks(): Flow<List<Task>> = localDataSource.getAllTasks().map {
        mapEntitiesToDomain(it)
    }
}