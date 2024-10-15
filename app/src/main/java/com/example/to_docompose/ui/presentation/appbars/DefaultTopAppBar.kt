package com.example.to_docompose.ui.presentation.appbars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.to_docompose.ui.presentation.TextResource
import com.example.to_docompose.ui.presentation.asString
import com.example.to_docompose.ui.presentation.preview.DayNightPreviews
import com.example.to_docompose.ui.theme.ToDoComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBar(
    modifier: Modifier = Modifier,
    props: DefaultTopAppBarProps,
) {
    TopAppBar(
        title = {Text(text = props.title.asString())},
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        )
    )
}

data class DefaultTopAppBarProps(
    val title: TextResource
){
    companion object{
        fun preview() = DefaultTopAppBarProps(
            title = TextResource.fromString("Text")
        )
    }
}


@DayNightPreviews
@Composable
private fun TabLayoutPreview() = ToDoComposeTheme() {
    DefaultTopAppBar(props = DefaultTopAppBarProps.preview())
}