package com.example.guessthat.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.guessthat.widgets.QuizTopAppBar

@Composable
fun RegisterScreen(navController: NavController)
{
    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    Scaffold(topBar = { QuizTopAppBar(title = "Register", navController = navController)}) {
        innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            Text(text = "Username")
            TextField(value = usernameInput, onValueChange = {usernameInput = it })
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Password")
            TextField(value = passwordInput, onValueChange = { passwordInput = it })
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Register")
            }
        }

    }
}

@Composable
@Preview
fun RegisterPreview()
{
    //RegisterScreen()
}