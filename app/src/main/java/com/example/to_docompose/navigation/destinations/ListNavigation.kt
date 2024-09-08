package com.example.to_docompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.to_docompose.ui.presentation.screens.taskslist.ListScreen
import com.example.to_docompose.utils.Constants.LIST_SCREEN

fun NavGraphBuilder.listNavigation(
) {
    composable(
        route = LIST_SCREEN
    ) {
        ListScreen()
    }
}