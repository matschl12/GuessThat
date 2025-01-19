package com.example.guessthat.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.guessthat.AuthState
import com.example.guessthat.AuthViewModel
import com.example.guessthat.Navigation.Screen
import com.example.guessthat.widgets.QuizTopAppBar

@Composable
fun GameSelectionScreen(navController: NavController, authViewModel: AuthViewModel) {

    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated -> navController.navigate(Screen.StartScreen.route)
            else -> Unit
        }
    }


    Scaffold(topBar = { QuizTopAppBar(title = "Game Selection", navController = navController) }) {
        innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            Text(
                text = "Game Selection",
            )
            Button(onClick = { navController.navigate(Screen.GeoQuizScreen.route)}) {
                Text(
                    text = "Geo Quiz",
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate(Screen.EstimationQuizScreen.route)}) {
                Text(
                    text = "Estimation Quiz",
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate(Screen.SportsQuizScreen.route)}) {
                Text(
                    text = "Sports Quiz",
                )
            }
            Spacer(modifier = Modifier.height(200.dp))
            Button(onClick = { authViewModel.signOut()}) {
                Text(
                    text = "Sign out",
                )
            }
        }
    }
}

@Composable
@Preview
fun gamescreenPreview(){
    //GameSelectionScreen()
}