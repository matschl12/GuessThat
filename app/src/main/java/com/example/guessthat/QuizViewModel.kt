package com.example.guessthat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class QuizViewModel: ViewModel(){

    var question by mutableStateOf("")
        private set
    var answer1 by mutableStateOf("")
        private set
    var answer2 by mutableStateOf("")
        private set
    var answer3 by mutableStateOf("")
        private set
    var answer4 by mutableStateOf("")
        private set

    fun changeQuestion() {
        question = "Question"
        answer1 = "Answer 1"
        answer2 = "Answer 2"
        answer3 = "Answer 3"
        answer4 = "Answer 4"

    }
}