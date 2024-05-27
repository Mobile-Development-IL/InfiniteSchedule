package com.infitelearning.development.infiniteschedule.data.local

import com.infitelearning.development.infiniteschedule.data.local.entity.TaskEntity
import com.infitelearning.development.infiniteschedule.data.local.room.TaskDao

class LocalDataSource private constructor(private val taskDao: TaskDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(taskDao: TaskDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(taskDao)
            }
    }

    suspend fun upsertTask(task: TaskEntity) = taskDao.upsertTask(task)

    suspend fun deleteTaskById(id: Int) = taskDao.deleteTaskById(id)

    fun getTaskById(taskId: Int) = taskDao.getTaskById(taskId)

    fun getAllTasks() = taskDao.getAllTasks()
}