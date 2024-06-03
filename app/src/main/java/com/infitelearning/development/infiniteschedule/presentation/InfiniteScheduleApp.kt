package com.infitelearning.development.infiniteschedule.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.infitelearning.development.infiniteschedule.presentation.navigation.InfiniteScheduleNavGraph

@Composable
fun InfiniteScheduleApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    InfiniteScheduleNavGraph(navController = navController, modifier = modifier)
}