package com.infitelearning.development.infiniteschedule.presentation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.infitelearning.development.infiniteschedule.presentation.navigation.Screen

fun NavGraphBuilder.homeScreenRoute(navController: NavController) {
    composable(route = Screen.Home.route) {
        HomeScreen(navController)
    }
}