package com.example.guessthat.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.guessthat.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizTopAppBar(title: String, navController: NavController){
    TopAppBar(
        title = {Text(text = title)},
        navigationIcon  = {
            IconButton(onClick = {navController.popBackStack()}) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Go Back")
            } },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}