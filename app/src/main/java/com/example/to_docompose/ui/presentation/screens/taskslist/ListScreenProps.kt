package com.example.to_docompose.ui.presentation.screens.taskslist

import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.ui.presentation.buttons.ListFabProps
import com.example.to_docompose.ui.presentation.screens.taskslist.model.ListState

internal class ListScreenProps(
    val fabProps: ListFabProps,
    val tasks: List<ToDoTask>
) {
    companion object{
        fun preview() = ListScreenProps(
            fabProps = ListFabProps.preview(),
            tasks = emptyList()
        )
    }
}

internal fun mapStateProps(
    state: ListState,
    fabOnClick: () -> Unit = {}
): ListScreenProps {
    return ListScreenProps(
        tasks = state.tasksList,
        fabProps = ListFabProps(
            onClick = fabOnClick
        )
    )
}