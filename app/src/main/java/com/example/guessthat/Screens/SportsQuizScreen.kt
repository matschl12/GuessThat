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
import androidx.compose.runtime.collectAsState
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
fun SportsQuizScreen(navController: NavController, viewModel: QuizViewModel, gameType: String) {
    var waitingRoom by remember { mutableStateOf(true) }
    val response by  viewModel.response.collectAsState()

    var singleOrMulti = "multi"
    val player = "player"

    var startButtonVisibility by remember { mutableStateOf(true) }
    Scaffold(topBar = { QuizTopAppBar(title = "Sports Quiz", navController = navController) }) {
            innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            if(singleOrMulti == "single")
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
            else
            {
                if(waitingRoom)
                {
                    viewModel.serverCheck()
                    if (response != null)
                    {
                        Text(text = "Server is currently " +response, color = Color.Green)
                        Button(onClick = {
                            viewModel.startQuiz(player,"", gameType)
                            waitingRoom = false
                        }, enabled = false) {
                            Text(text = "Play Game")
                        }

                    }
                    else
                    {
                        Text(text = "Server is currently offline", color = Color.Red)
                    }
                }
                else
                {
                    SelectiveQuiz(innerPadding = innerPadding, viewModel = viewModel )
                }
            }
        }
    }
}