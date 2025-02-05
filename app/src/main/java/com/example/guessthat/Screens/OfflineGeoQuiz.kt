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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.guessthat.AuthState
import com.example.guessthat.Navigation.Screen
import com.example.guessthat.QuizViewModel
import com.example.guessthat.widgets.KeyboardQuiz
import com.example.guessthat.widgets.QuizTopAppBar
import com.example.guessthat.widgets.SelectiveQuiz

@Composable
fun OfflineGeoQuizScreen(navController: NavController, viewModel: QuizViewModel, gameType: String) {
    val player = "player"
    var startButtonVisibility by remember { mutableStateOf(true) }
    Scaffold(topBar = { QuizTopAppBar(title = "Geo Quiz", navController = navController) }) {
            innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            if(startButtonVisibility) {
                Button(onClick = {
                    viewModel.startQuiz(player, "", gameType)
                    startButtonVisibility = false
                }) {
                    Text(text = "Start", fontSize = 25.sp)
                }
            }
            else{
                SelectiveQuiz(innerPadding = innerPadding, viewModel = viewModel )
            }
        }
    }

}
