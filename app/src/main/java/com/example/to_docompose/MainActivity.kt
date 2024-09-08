package com.example.to_docompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.to_docompose.navigation.AppNavHost
import com.example.to_docompose.ui.presentation.screens.taskslist.ListScreen
import com.example.to_docompose.ui.theme.ToDoComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var mainNavHost: AppNavHost

    private val onEmptyBackstackBack = {
        onBackPressedDispatcher.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoComposeTheme {
                val navController = rememberNavController()
                mainNavHost(
                    modifier = Modifier,
                    navController = navController,
                    onEmptyBackstackBack = onEmptyBackstackBack
                )
                ListScreen()
            }
        }
    }
}