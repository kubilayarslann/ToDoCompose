package com.example.to_docompose.navigation.destinations

import com.example.to_docompose.utils.Actions

interface ScreensNavigator {
    fun taskScreen(taskId: Int)
    fun listScreen(action: Actions)
    fun navigateBack()
}