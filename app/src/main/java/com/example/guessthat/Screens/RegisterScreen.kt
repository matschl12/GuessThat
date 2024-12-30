package com.example.guessthat.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.guessthat.AuthState
import com.example.guessthat.AuthViewModel
import com.example.guessthat.Navigation.Screen
import com.example.guessthat.widgets.QuizTopAppBar

@Composable
fun RegisterScreen(navController: NavController, authViewModel:AuthViewModel)
{
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    val authState  = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value){
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate(Screen.GameSelectionScreen.route)
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }
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
            Text(text = "Email")
            TextField(value = emailInput, onValueChange = {emailInput = it })
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Password")
            TextField(value = passwordInput, onValueChange = { passwordInput = it })
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { authViewModel.signUp(emailInput, passwordInput) },
                enabled = authState.value != AuthState.Loading
            )
            {
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