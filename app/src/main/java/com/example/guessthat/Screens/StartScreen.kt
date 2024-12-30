package com.example.guessthat.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.guessthat.Navigation.Screen


@Composable
fun StartScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Text(
            text = "Start screen",
        )
        Button(onClick = { navController.navigate(Screen.LoginScreen.route)}) {
            Text(
                text = "Multiplayer",
            )
        }
        Button(onClick = { navController.navigate(Screen.OfflineGameSelectionScreen.route)}) {
            Text(
                text = "Singleplayer",
            )
        }
    }
}

@Composable
@Preview
fun screenPreview(){
    //StartScreen()
}