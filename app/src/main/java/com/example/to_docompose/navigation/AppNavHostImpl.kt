package com.example.to_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_docompose.navigation.handler.NavigationHandler
import com.example.to_docompose.navigation.manager.mainNavigation
import com.example.to_docompose.utils.Constants.LIST_SCREEN
import com.smarthome.core.presentation.navigation.manager.NavigationManager
import javax.inject.Inject


class AppNavHostImpl @Inject constructor(
    private val navigationManager: NavigationManager
) : AppNavHost {

    @Composable
    override fun invoke(
        modifier: Modifier,
        navController: NavHostController,
        onEmptyBackstackBack: () -> Unit
    ) {
        NavigationHandler(navController, navigationManager, onEmptyBackstackBack)
        NavHost(
            navController = navController,
            startDestination = LIST_SCREEN,
            modifier = modifier
        ) {
            mainNavigation()
        }
    }
}