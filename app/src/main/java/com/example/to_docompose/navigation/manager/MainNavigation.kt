package com.example.to_docompose.navigation.manager

import androidx.navigation.NavGraphBuilder
import com.example.to_docompose.navigation.destinations.listNavigation
import com.example.to_docompose.navigation.destinations.taskNavigation


internal fun NavGraphBuilder.mainNavigation() {
    listNavigation()
    taskNavigation()
}