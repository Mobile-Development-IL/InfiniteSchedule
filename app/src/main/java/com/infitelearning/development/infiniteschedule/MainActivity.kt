package com.infitelearning.development.infiniteschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.infitelearning.development.infiniteschedule.presentation.InfiniteScheduleApp
import com.infitelearning.development.infiniteschedule.ui.theme.InfiniteScheduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfiniteScheduleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InfiniteScheduleApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}