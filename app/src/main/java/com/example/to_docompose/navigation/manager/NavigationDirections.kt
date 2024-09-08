package com.smarthome.core.presentation.navigation.manager

import androidx.navigation.NavOptions
import androidx.navigation.Navigator

data class NavigationDirections(
    val destination: String,
    val navOptions: NavOptions? = null,
    val navExtras: Navigator.Extras? = null
)