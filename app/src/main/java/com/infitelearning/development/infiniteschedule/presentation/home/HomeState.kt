package com.infitelearning.development.infiniteschedule.presentation.home

import com.infitelearning.development.infiniteschedule.data.local.entity.TaskEntity

data class HomeState(
    val tasks: List<TaskEntity> = emptyList()
)
