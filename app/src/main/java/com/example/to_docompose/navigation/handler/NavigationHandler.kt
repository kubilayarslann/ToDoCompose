package com.example.to_docompose.navigation.handler

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.to_docompose.utils.getActivity
import com.smarthome.core.presentation.navigation.manager.NavigationCommand
import com.smarthome.core.presentation.navigation.manager.NavigationManager

@SuppressLint("RestrictedApi")
@Composable
fun NavigationHandler(
    navController: NavHostController,
    navigationManager: NavigationManager,
    onEmptyBackstackBack: () -> Unit
) {
    val context = LocalContext.current
    val backstack by navController.currentBackStack.collectAsState()
    PrintBackStack(backstack)

    LaunchedEffect(key1 = navigationManager, key2 = navController) {
        navigationManager.navigationCommandFlow.collect { command ->
            Log.d ("NavigationHandler", "NavigationCommand: $command")
            when (command) {
                is NavigationCommand.NavigateTo -> {
                    command.directions.let {
                        navController.navigate(it.destination, it.navOptions, it.navExtras)
                    }
                }
                is NavigationCommand.Back -> {
                    command.directions?.let {
                        val dest = it.destination
                            ?: navController.previousBackStackEntry?.destination?.route
                            ?: error("Back command with null destination should not be used from root destination")
                        navController.popBackStack(dest, it.inclusive, it.saveState)
                    } ?: run {
                        navController.popBackStack()
                    }
                    if (navController.currentBackStackEntry?.destination?.route == null) {
                        onEmptyBackstackBack()
                    }
                }
                is NavigationCommand.Finish -> {
                    context.getActivity()?.finish()
                }
                is NavigationCommand.Recreate -> {
                    context.getActivity()?.recreate()
                }
            }
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
private fun PrintBackStack(backstack: List<NavBackStackEntry>) {
    val backstackString = backstack.joinToString(" -> ") {
        it.destination.route ?: it.destination.displayName
    }
    Log.d ("NavigationHandler", "BACKSTACK: [$backstackString]")
}