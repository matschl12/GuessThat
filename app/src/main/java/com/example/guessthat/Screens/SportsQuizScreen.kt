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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.guessthat.Navigation.Screen
import com.example.guessthat.QuizViewModel
import com.example.guessthat.widgets.QuizTopAppBar
import com.example.guessthat.widgets.SelectiveQuiz

@Composable
fun SportsQuizScreen(navController: NavController, viewModel: QuizViewModel) {
    var startButtonVisibility by remember { mutableStateOf(true) }
    Scaffold (topBar = { QuizTopAppBar(title = "Sports Quiz", navController = navController) }){
        innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally) {
            if(startButtonVisibility) {
                Button(onClick = {
                    viewModel.startQuiz()
                    startButtonVisibility = false
                }) {
                    Text(text = "Start", fontSize = 25.sp)
                }
            }
        }
        if(!startButtonVisibility)
        {
            SelectiveQuiz(innerPadding = innerPadding, viewModel = viewModel )
        }

    }
}