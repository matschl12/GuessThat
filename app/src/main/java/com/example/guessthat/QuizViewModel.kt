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

    private val _estimation = MutableStateFlow("")
    var estimation = _estimation.asStateFlow()


    var questionNum = 0
    var questionNumText by mutableStateOf(questionNum.toString())
        private set




    lateinit var quizQuestions: List<Question>


    fun startQuiz(gameType: String) {
        val quizGame = QuizGame("Paul", gameType)
        questionNum = 0
        score = 0
        quizQuestions = quizGame.selectQuestions()
        questionNumText = (questionNum+1).toString()
        question = quizQuestions[0].question
        answer1 = quizQuestions.getOrNull(0)?.answer1.toString()
        answer2 = quizQuestions.getOrNull(0)?.answer2.toString()
        answer3 = quizQuestions.getOrNull(0)?.answer3.toString()
        answer4 = quizQuestions.getOrNull(0)?.answer4.toString()
        solution = quizQuestions[0].solution
        _gameType.value = gameType
    }

    fun nextQuestion() {
        questionNum++
        questionNumText = (questionNum+1).toString()
        question = quizQuestions[questionNum].question
        answer1 = quizQuestions.getOrNull(questionNum)?.answer1.toString()
        answer2 = quizQuestions.getOrNull(questionNum)?.answer2.toString()
        answer3 = quizQuestions.getOrNull(questionNum)?.answer3.toString()
        answer4 = quizQuestions.getOrNull(questionNum)?.answer4.toString()
        solution = quizQuestions[questionNum].solution
    }

    fun validateAnswer(buttonNum: Int){
        if (quizQuestions[questionNum].answer1 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Green
            _button2color.value = Color.Red
            _button3color.value = Color.Red
            _button4color.value = Color.Red

            if(buttonNum == 1)
            {
                score += 100
            }

        }
        else if (quizQuestions[questionNum].answer2 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Green
            _button3color.value = Color.Red
            _button4color.value = Color.Red

            if(buttonNum == 2)
            {
                score += 100
            }
        }
        else if (quizQuestions[questionNum].answer3 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Red
            _button3color.value = Color.Green
            _button4color.value = Color.Red

            if(buttonNum == 3)
            {
                score += 100
            }
        }
        else if (quizQuestions[questionNum].answer4 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Red
            _button3color.value = Color.Red
            _button4color.value = Color.Green

            if(buttonNum == 4)
            {
                score += 100
            }
        }
    }

    fun validateEstimation(){
        //here calculation between guess and solution
        // for now
        if(estimation.value == quizQuestions[questionNum].solution)
        {
            score += 100
        }
    }

    fun startNewGame(){

    }



}