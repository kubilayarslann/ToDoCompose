package com.example.to_docompose.ui.presentation.buttons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.to_docompose.R
import com.example.to_docompose.ui.presentation.preview.DayNightPreviews

@Composable
fun ListFab(
    modifier: Modifier = Modifier,
    props: ListFabProps
) {
    FloatingActionButton(
        onClick = props.onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_task_floating_button),
        )

    }
}

data class ListFabProps(
    val onClick: () -> Unit
) {
    companion object {
        fun preview() = ListFabProps(
            onClick = {}
        )
    }
}


@DayNightPreviews
@Composable
private fun ListFabPreview(
    @PreviewParameter(ListFabPreviewParameterProvider::class) props: ListFabProps
) = MaterialTheme {
    ListFab(props = props)
}

private class ListFabPreviewParameterProvider :
    PreviewParameterProvider<ListFabProps> {
    override val values: Sequence<ListFabProps> = sequenceOf(
        ListFabProps.preview()
    )
}