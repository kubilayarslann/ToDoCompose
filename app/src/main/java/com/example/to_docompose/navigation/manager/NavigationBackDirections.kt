package com.smarthome.core.presentation.navigation.manager

data class NavigationBackDirections(
    val destination: String?,
    val inclusive: Boolean = false,
    val saveState: Boolean = false
)