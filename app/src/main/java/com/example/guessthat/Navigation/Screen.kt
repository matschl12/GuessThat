package com.example.guessthat.Navigation

sealed class Screen(val route: String) {
    object StartScreen: Screen("start_screen")
    object RegisterScreen: Screen("register_screen")
    object LoginScreen: Screen("login_screen")
    object GameSelectionScreen: Screen("game_selection_screen")
    object OfflineGameSelectionScreen: Screen("off_game_selection_screen")
    object GeoQuizScreen: Screen("geo_quiz_screen")
    object OfflineGeoQuizScreen: Screen("off_geo_quiz_screen")
    object EstimationQuizScreen: Screen("estimation_quiz_screen")
    object OfflineEstimationQuizScreen: Screen("off_estimation_quiz_screen")
    object SportsQuizScreen: Screen("sports_quiz_screen")
    object OfflineSportsQuizScreen: Screen("off_sports_quiz_screen")
}

