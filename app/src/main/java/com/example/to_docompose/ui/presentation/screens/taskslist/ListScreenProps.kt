package com.example.to_docompose.ui.presentation.screens.taskslist

import com.example.to_docompose.ui.presentation.buttons.ListFabProps

internal class ListScreenProps(
    fabProps: ListFabProps
) {
    companion object{
        fun preview() = ListScreenProps(
            fabProps = ListFabProps.preview()
        )
    }
}

internal fun mapStateProps(
    fabOnClick: () -> Unit = {}
): ListScreenProps {
    return ListScreenProps(
        fabProps = ListFabProps(
            onClick = fabOnClick
        )
    )
}