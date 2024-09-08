package com.example.to_docompose.navigation

import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import com.example.to_docompose.navigation.destinations.ScreensNavigator
import com.example.to_docompose.utils.Actions
import com.example.to_docompose.utils.Constants.LIST_ARGUMENT_KEY
import com.example.to_docompose.utils.Constants.LIST_SCREEN
import com.example.to_docompose.utils.Constants.TASK_ARGUMENT_KEY
import com.example.to_docompose.utils.Constants.TASK_SCREEN
import com.smarthome.core.presentation.navigation.manager.NavigationDirections
import com.smarthome.core.presentation.navigation.manager.NavigationManager
import com.smarthome.core.presentation.navigation.manager.populatePathNavArgs
import javax.inject.Inject

class ScreensNavigatorImpl @Inject constructor(
    private val navigationManager: NavigationManager,
) : ScreensNavigator {

    override fun taskScreen(taskId: Int) {
        navigationManager.navigateTo(
            directions =
            NavigationDirections(
                destination = TASK_SCREEN.populatePathNavArgs(
                    mapOf(TASK_ARGUMENT_KEY to taskId)
                )
            )
        )
    }

    override fun listScreen(action: Actions) {
        navigationManager.navigateTo(
            directions = NavigationDirections(
                destination = LIST_SCREEN.populatePathNavArgs(
                    mapOf(LIST_ARGUMENT_KEY to action)
                ),
                navOptions = navOptions {
                    popUpTo(LIST_SCREEN) {
                        inclusive = true
                    }
                }
            )
        )
    }

    override fun navigateBack() {
        navigationManager.navigateBack()
    }
}