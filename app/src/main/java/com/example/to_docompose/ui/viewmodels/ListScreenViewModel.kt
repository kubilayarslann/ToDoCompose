package com.example.to_docompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.navigation.destinations.ScreensNavigator
import com.example.to_docompose.ui.presentation.screens.taskslist.model.ListState
import com.example.to_docompose.usecases.GetAllTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val screensNavigator: ScreensNavigator
) : ViewModel() {


    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //This one also must be state flow members.
            _state.update {
                it.copy(
                    tasksList = getAllTasksUseCase()
                )
            }
        }
    }

    fun fabButtonClicked() {
        screensNavigator.taskScreen(taskId = -1)
    }
}