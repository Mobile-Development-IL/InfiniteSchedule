package com.infitelearning.development.infiniteschedule.presentation.task

import com.infitelearning.development.infiniteschedule.data.local.entity.TaskEntity

data class TaskState(
    val title: String = "",
    val description: String = "",
    val source: String = "",
    val location: String = "",
    val isDatePickerDialogOpen: Boolean = false,
    val dueDate: Long? = null,
    val currentTaskId: Int? = null,
)
