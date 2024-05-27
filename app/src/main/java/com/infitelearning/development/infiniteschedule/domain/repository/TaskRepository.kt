package com.infitelearning.development.infiniteschedule.domain.repository

import com.infitelearning.development.infiniteschedule.data.local.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun upsertTask(taskEntity: TaskEntity)

    suspend fun deleteTask(taskId: Int)

    fun getTaskById(taskId: Int): Flow<TaskEntity?>

    fun getAllTasks(): Flow<List<TaskEntity>>
}