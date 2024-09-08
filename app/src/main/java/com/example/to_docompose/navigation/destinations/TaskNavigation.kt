package com.example.to_docompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.utils.Constants.TASK_ARGUMENT_KEY
import com.example.to_docompose.utils.Constants.TASK_SCREEN

fun NavGraphBuilder.taskNavigation() {
    composable(
        route = TASK_SCREEN
    ) {
        //TaskScreen(navigateToListScreen = screensNavigator::listScreen)
    }
}