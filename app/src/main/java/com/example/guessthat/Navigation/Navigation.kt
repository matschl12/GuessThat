package com.example.guessthat.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.guessthat.Screens.EstimationQuizScreen
import com.example.guessthat.Screens.GameSelectionScreen
import com.example.guessthat.Screens.GeoQuizScreen
import com.example.guessthat.Screens.SportsQuizScreen
import com.example.guessthat.Screens.StartScreen

@Composable
fun Navigation()
{
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.StartScreen.route
    ) {

        composable(route = Screen.StartScreen.route) {
            StartScreen(navController)
        }

        composable(route = Screen.GameSelectionScreen.route) {
            GameSelectionScreen(navController)
        }

        composable(route = Screen.GeoQuizScreen.route) {
            GeoQuizScreen(navController)
        }

        composable(route = Screen.EstimationQuizScreen.route) {
            EstimationQuizScreen(navController)
        }

        composable(route = Screen.SportsQuizScreen.route) {
            SportsQuizScreen(navController)
        }


    }
}