package com.infitelearning.development.infiniteschedule.presentation.home

import android.content.Context
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.infitelearning.development.infiniteschedule.R
import com.infitelearning.development.infiniteschedule.data.local.entity.TaskEntity
import com.infitelearning.development.infiniteschedule.presentation.navigation.Screen
import com.infitelearning.development.infiniteschedule.utils.Converter.changeMillisToDateString
import com.infitelearning.development.infiniteschedule.utils.ViewModelFactory
import com.rahmadev.storage.presentation.component.TaskCard

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    isDarkMode: Boolean = isSystemInDarkTheme(),
    listState: LazyListState = rememberLazyListState(),
) {
    val homeViewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory.getInstance(context)
    )
    val state by homeViewModel.state.collectAsStateWithLifecycle()
    val isFABExpanded by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }

    HomeContent(
        tasks = state.tasks,
        isDarkMode = isDarkMode,
        isFABExpanded = isFABExpanded,
        navController = navController,
        onFabClicked = {
            navController.navigate(Screen.Task.createRoute(0))
        },
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    tasks: List<TaskEntity>,
    isDarkMode: Boolean,
    isFABExpanded: Boolean,
    navController: NavController,
    onFabClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Image(
                        painter = painterResource(if (!isDarkMode) R.drawable.infinite_dark else R.drawable.infinite_light),
                        contentDescription = "Infinite Icon",
                        modifier = Modifier.width(140.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onFabClicked,
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "Add") },
                text = { Text(text = "Add Task") },
                expanded = isFABExpanded
            )
        },
        modifier = modifier
    ) { contentPadding ->
        if (tasks.isEmpty())
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.img_tasks),
                    contentDescription = "Task Image",
                    modifier = Modifier.height(200.dp)
                )
            }
        else
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = modifier.padding(contentPadding)
            ) {
                items(tasks, key = { it.taskId ?: 0 }) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        TaskCard(
                            title = it.title,
                            date = it.dueDate.changeMillisToDateString(),
                            onItemTaskClicked = { navController.navigate(Screen.Task.createRoute(it.taskId)) }
                        )
                    }
                }
            }
    }
}
