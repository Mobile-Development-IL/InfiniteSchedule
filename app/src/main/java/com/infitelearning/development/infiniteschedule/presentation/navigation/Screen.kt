package com.infitelearning.development.infiniteschedule.presentation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Task : Screen("task/{id}") {
        fun createRoute(id: Int?) = "task/$id"
    }
}