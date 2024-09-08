package com.smarthome.core.presentation.navigation.manager

import kotlinx.coroutines.flow.SharedFlow

interface NavigationManager {
    val navigationCommandFlow: SharedFlow<NavigationCommand>
    fun navigateTo(directions: NavigationDirections)
    fun navigateBack(directions: NavigationBackDirections? = null)
    fun finish()
    fun recreate()
}