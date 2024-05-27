package com.infitelearning.development.infiniteschedule.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val taskId: Int? = null,
    val title: String,
    val description: String,
    val dueDate: Long,
    val linkSource: String,
    val location: String
): Parcelable
