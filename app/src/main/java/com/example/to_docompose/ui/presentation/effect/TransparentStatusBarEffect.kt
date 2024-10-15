package com.example.to_docompose.ui.presentation.effect

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TransparentStatusBarEffect() {
    val systemUiController = rememberSystemUiController()

    DisposableEffect(systemUiController) {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = true
        )
        onDispose {}
    }
}
