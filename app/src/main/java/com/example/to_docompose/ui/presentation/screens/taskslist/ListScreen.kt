package com.example.to_docompose.ui.presentation.screens.taskslist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.compose.rememberNavController
import com.example.to_docompose.navigation.AppNavHost
import com.example.to_docompose.ui.presentation.buttons.ListFab
import com.example.to_docompose.ui.presentation.buttons.ListFabProps
import com.example.to_docompose.ui.presentation.preview.DayNightPreviews

@Composable
fun ListScreen() {

    ListScreenUiContent(
        props = mapStateProps(

        )
    )
}

@Composable
private fun ListScreenUiContent(
    props: ListScreenProps
) {
    Scaffold(
        content = {},
        floatingActionButton = {
            ListFab(props = ListFabProps {

            })
        }
    )
}

@DayNightPreviews
@Composable
private fun ListFabPreview(
    @PreviewParameter(ListScreenPreviewParameterProvider::class) props: ListScreenProps
) = MaterialTheme {
    ListScreenUiContent(props = props)
}

private class ListScreenPreviewParameterProvider :
    PreviewParameterProvider<ListScreenProps> {
    override val values: Sequence<ListScreenProps> = sequenceOf(
        ListScreenProps.preview()
    )
}