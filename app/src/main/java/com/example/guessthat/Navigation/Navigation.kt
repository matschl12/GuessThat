package com.example.guessthat.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.guessthat.QuizViewModel
import com.example.guessthat.Screens.EstimationQuizScreen
import com.example.guessthat.Screens.GameSelectionScreen
import com.example.guessthat.Screens.GeoQuizScreen
import com.example.guessthat.Screens.LoginScreen
import com.example.guessthat.Screens.RegisterScreen
import com.example.guessthat.Screens.SportsQuizScreen
import com.example.guessthat.Screens.StartScreen

@Composable
fun Navigation()
{
    val navController = rememberNavController()
    val quizViewModel: QuizViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.StartScreen.route
    ) {

        composable(route = Screen.StartScreen.route) {
            StartScreen(navController)
        }

        composable(route = Screen.RegisterScreen.route) {
           RegisterScreen(navController)
        }

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController)
        }

        composable(route = Screen.GameSelectionScreen.route) {
            GameSelectionScreen(navController)
        }

        composable(route = Screen.GeoQuizScreen.route) {
            GeoQuizScreen(navController, quizViewModel, "Geo")
        }

        composable(route = Screen.EstimationQuizScreen.route) {
            EstimationQuizScreen(navController, quizViewModel, "Estimation")
        }

        composable(route = Screen.SportsQuizScreen.route) {
            SportsQuizScreen(navController, quizViewModel, "Sport")
        }


    }
}