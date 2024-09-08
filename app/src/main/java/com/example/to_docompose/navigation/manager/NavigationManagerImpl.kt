package com.smarthome.core.presentation.navigation.manager

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class NavigationManagerImpl @Inject constructor() : NavigationManager {

    private val _navigationCommandFlow = MutableSharedFlow<NavigationCommand>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    override val navigationCommandFlow = _navigationCommandFlow

    override fun navigateTo(
        directions: NavigationDirections
    ) {
        _navigationCommandFlow.tryEmit(NavigationCommand.NavigateTo(directions))
    }

    override fun navigateBack(directions: NavigationBackDirections?) {
        _navigationCommandFlow.tryEmit(NavigationCommand.Back(directions))
    }

    override fun finish() {
        _navigationCommandFlow.tryEmit(NavigationCommand.Finish)
    }

    override fun recreate() {
        _navigationCommandFlow.tryEmit(NavigationCommand.Recreate)
    }
}