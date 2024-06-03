package com.infitelearning.development.infiniteschedule.presentation.home

import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.infitelearning.development.infiniteschedule.presentation.InfiniteScheduleApp
import com.infitelearning.development.infiniteschedule.presentation.MainActivity
import com.infitelearning.development.infiniteschedule.presentation.navigation.Screen
import com.infitelearning.development.infiniteschedule.ui.theme.InfiniteScheduleTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class HomeScreenKtTest{
    @get: Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get: Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp(){
        hiltRule.inject()
        composeTestRule.activity.setContent {
            InfiniteScheduleTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                InfiniteScheduleApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination(){
        composeTestRule.onNodeWithContentDescription("Add").assertIsDisplayed()
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_navigateToAddTask(){
        composeTestRule.onNodeWithContentDescription("Add").performClick()
        navController.assertCurrentRouteName(Screen.Task.route)
    }

    @Test
    fun navHost_addTaskData(){
        composeTestRule.run {
            composeTestRule.onNodeWithContentDescription("Add").performClick()
            navController.assertCurrentRouteName(Screen.Task.route)
            onNodeWithTag("title_input").performTextInput("Rahmad")
            onNodeWithTag("description_input").performTextInput("Rahmad and reza")
            onNodeWithContentDescription("Select Due Date").performClick()
            onNodeWithTag("date_input").performClick()
            onNodeWithText("OK").performClick()
            onNodeWithTag("source").performTextInput("https://Google.com")
            onNodeWithTag("location").performTextInput("rusun")
            onNodeWithText("Save").performClick()
        }
    }

    @Test
    fun navHost_detailTask(){
        composeTestRule.run {
            composeTestRule.onNodeWithContentDescription("Add").performClick()
            navController.assertCurrentRouteName(Screen.Task.route)
            onNodeWithTag("title_input").performTextInput("Rahmad")
            onNodeWithTag("description_input").performTextInput("Rahmad and reza")
            onNodeWithContentDescription("Select Due Date").performClick()
            onNodeWithTag("date_input").performClick()
            onNodeWithText("OK").performClick()
            onNodeWithTag("source").performTextInput("https://Google.com")
            onNodeWithTag("location").performTextInput("rusun")
            onNodeWithText("Save").performClick()
            navController.assertCurrentRouteName(Screen.Home.route)
            onNodeWithText("Rahmad").performClick()
            onNodeWithText("Rahmad").assertIsDisplayed()
            onNodeWithText("Rahmad and reza").assertIsDisplayed()
            onNodeWithText("https://Google.com").assertIsDisplayed()
        }
    }

    @Test
    fun navHost_deleteTask(){
        composeTestRule.run {
            composeTestRule.onNodeWithContentDescription("Add").performClick()
            navController.assertCurrentRouteName(Screen.Task.route)
            onNodeWithTag("title_input").performTextInput("Rahmad")
            onNodeWithTag("description_input").performTextInput("Rahmad and reza")
            onNodeWithContentDescription("Select Due Date").performClick()
            onNodeWithTag("date_input").performClick()
            onNodeWithText("OK").performClick()
            onNodeWithTag("source").performTextInput("https://Google.com")
            onNodeWithTag("location").performTextInput("rusun")
            onNodeWithText("Save").performClick()
            navController.assertCurrentRouteName(Screen.Home.route)
            onNodeWithText("Rahmad").performClick()
            onNodeWithText("Rahmad").assertIsDisplayed()
            onNodeWithText("Rahmad and reza").assertIsDisplayed()
            onNodeWithText("https://Google.com").assertIsDisplayed()
            onNodeWithContentDescription("Delete Task").performClick()
            onNodeWithText("Rahmad").assertDoesNotExist()
        }
    }
}