package com.infitelearning.development.infiniteschedule.presentation.home

import com.infitelearning.development.infiniteschedule.domain.model.Task

data class HomeState(
    val tasks: List<Task> = emptyList()
)
