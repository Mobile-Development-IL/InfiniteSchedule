package com.infitelearning.development.infiniteschedule.domain.usecase

import com.infitelearning.development.infiniteschedule.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskUseCase {
    suspend fun upsertTask(task: Task)

    suspend fun deleteTask(taskId: Int)

    fun getTaskById(taskId: Int): Flow<Task?>

    fun getAllTasks(): Flow<List<Task>>
}