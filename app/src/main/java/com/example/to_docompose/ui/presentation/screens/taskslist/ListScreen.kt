package com.example.to_docompose.ui.presentation.screens.taskslist

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.to_docompose.ui.presentation.appbars.DefaultTopAppBar
import com.example.to_docompose.ui.presentation.buttons.ListFab
import com.example.to_docompose.ui.presentation.buttons.ListFabProps
import com.example.to_docompose.ui.presentation.preview.DayNightPreviews
import com.example.to_docompose.ui.viewmodels.ListScreenViewModel

@Composable
fun ListScreen(
    viewModel: ListScreenViewModel = hiltViewModel()
) {

    ListScreenUiContent(
        props = mapStateProps(
            state = viewModel.state.collectAsStateWithLifecycle().value,
            fabOnClick = viewModel::fabButtonClicked
        )
    )
}

@Composable
private fun ListScreenUiContent(
    props: ListScreenProps
) {
    Scaffold(
        topBar = {
            DefaultTopAppBar(
                props = props.defaultTopAppBarProps
            )
        },
        content = {},
        floatingActionButton = {
            ListFab(props = props.fabProps)
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