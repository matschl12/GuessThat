package com.example.guessthat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.guessthat.GameLogic.Question
import com.example.guessthat.GameLogic.QuizGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

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
    var score by mutableStateOf(0)
        private set
    var solution by mutableStateOf("")
        private set
    private val _button1color = MutableStateFlow(Color.LightGray)
    val button1color = _button1color.asStateFlow()

    private val _button2color = MutableStateFlow(Color.LightGray)
    val button2color = _button2color.asStateFlow()

    private val _button3color = MutableStateFlow(Color.LightGray)
    val button3color = _button3color.asStateFlow()

    private val _button4color = MutableStateFlow(Color.LightGray)
    val button4color = _button4color.asStateFlow()

    private val _gameType = MutableStateFlow("")
    val gameType = _gameType.asStateFlow()


    var questionNum = 0
    var questionNumText by mutableStateOf(questionNum.toString())
        private set




    lateinit var quizQuestions: List<Question>


    fun startQuiz(gameType: String) {
        val quizGame: QuizGame = QuizGame("Paul", gameType)
        questionNum = 0
        score = 0
        quizQuestions = quizGame.selectQuestions()
        questionNumText = (questionNum+1).toString()
        question = quizQuestions[0].question
        answer1 = quizQuestions[0].answer1
        answer2 = quizQuestions[0].answer2
        answer3 = quizQuestions[0].answer3
        answer4 = quizQuestions[0].answer4
        solution = quizQuestions[0].solution
        _gameType.value = gameType
    }

    fun nextQuestion() {
        questionNum++
        questionNumText = (questionNum+1).toString()
        question = quizQuestions[questionNum].question
        answer1 = quizQuestions[questionNum].answer1
        answer2 = quizQuestions[questionNum].answer2
        answer3 = quizQuestions[questionNum].answer3
        answer4 = quizQuestions[questionNum].answer4
        solution = quizQuestions[questionNum].solution
    }

    fun validateAnswer(buttonnum: Int){
        if (quizQuestions[questionNum].answer1 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Green
            _button2color.value = Color.Red
            _button3color.value = Color.Red
            _button4color.value = Color.Red

            if(buttonnum == 1)
            {
                score += 100
            }

        }
        else if (quizQuestions[questionNum].answer2 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Green
            _button3color.value = Color.Red
            _button4color.value = Color.Red

            if(buttonnum == 2)
            {
                score += 100
            }
        }
        else if (quizQuestions[questionNum].answer3 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Red
            _button3color.value = Color.Green
            _button4color.value = Color.Red

            if(buttonnum == 3)
            {
                score += 100
            }
        }
        else if (quizQuestions[questionNum].answer4 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Red
            _button3color.value = Color.Red
            _button4color.value = Color.Green

            if(buttonnum == 4)
            {
                score += 100
            }
        }
    }

    fun startNewGame(){

    }



}