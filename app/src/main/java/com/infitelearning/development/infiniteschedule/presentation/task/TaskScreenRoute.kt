package com.infitelearning.development.infiniteschedule.presentation.task

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.infitelearning.development.infiniteschedule.presentation.navigation.Screen

fun NavGraphBuilder.taskScreenRoute(navController: NavController) {
    composable(
        route = Screen.Task.route,
        arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )
    ) {
        val taskId = it.arguments?.getInt("id", 0)
        TaskScreen(id = taskId ?: 0, navController)
    }
}