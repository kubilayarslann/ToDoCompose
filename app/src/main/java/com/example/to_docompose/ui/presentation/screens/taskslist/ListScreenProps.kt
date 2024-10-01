package com.example.to_docompose.ui.presentation.screens.taskslist

import androidx.compose.ui.res.stringResource
import com.example.to_docompose.R
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.ui.presentation.TextResource
import com.example.to_docompose.ui.presentation.appbars.DefaultTopAppBarProps
import com.example.to_docompose.ui.presentation.buttons.ListFabProps
import com.example.to_docompose.ui.presentation.screens.taskslist.model.ListState

internal class ListScreenProps(
    val defaultTopAppBarProps: DefaultTopAppBarProps,
    val fabProps: ListFabProps,
    val tasks: List<ToDoTask>
) {
    companion object{
        fun preview() = ListScreenProps(
            fabProps = ListFabProps.preview(),
            tasks = emptyList(),
            defaultTopAppBarProps = DefaultTopAppBarProps.preview()
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
        ),
        defaultTopAppBarProps = DefaultTopAppBarProps(
            title = TextResource.fromId(id = R.string.tasks)
        )
    )
}