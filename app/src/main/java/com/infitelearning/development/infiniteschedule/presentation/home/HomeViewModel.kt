package com.infitelearning.development.infiniteschedule.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infitelearning.development.infiniteschedule.data.local.entity.TaskEntity
import com.infitelearning.development.infiniteschedule.domain.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val taskRepository: TaskRepository): ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getAllTasks()
    }

    private fun getAllTasks() = viewModelScope.launch(Dispatchers.IO) {
        taskRepository.getAllTasks().collect { tasks ->
            _state.update {
                it.copy(tasks = tasks)
            }
        }
    }
}