package com.luckgg.catdex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luckgg.presentation.Screen
import com.luckgg.presentation.screen.CatListScreen
import com.luckgg.presentation.ui.theme.CatDexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CatDexTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.CatListScreen.route,
                ) {
                    composable(
                        route = Screen.CatListScreen.route,
                    ) {
                        CatListScreen(navController)
                    }
                }
            }
        }
    }
}
