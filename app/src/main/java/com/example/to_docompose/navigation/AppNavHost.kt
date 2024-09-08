package com.example.to_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

interface AppNavHost {
    @Composable
    operator fun invoke(
        modifier: Modifier,
        navController: NavHostController,
        onEmptyBackstackBack: () -> Unit
    )
}