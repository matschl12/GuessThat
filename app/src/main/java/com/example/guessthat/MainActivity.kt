package com.example.guessthat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.guessthat.Navigation.Navigation
import com.example.guessthat.ui.theme.GuessThatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessThatTheme {
                    Navigation()
            }
        }
    }
}

