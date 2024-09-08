package com.smarthome.core.presentation.navigation.manager

sealed class NavigationCommand {
    data class NavigateTo(val directions: NavigationDirections) : NavigationCommand()
    data class Back(val directions: NavigationBackDirections? = null) : NavigationCommand()
    data object Finish : NavigationCommand()
    data object Recreate : NavigationCommand()
}