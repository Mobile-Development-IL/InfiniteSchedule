package com.infitelearning.development.infiniteschedule.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.infitelearning.development.infiniteschedule.presentation.home.homeScreenRoute
import com.infitelearning.development.infiniteschedule.presentation.task.taskScreenRoute

@Composable
fun InfiniteScheduleNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        homeScreenRoute(navController)
        taskScreenRoute(navController)
    }
}