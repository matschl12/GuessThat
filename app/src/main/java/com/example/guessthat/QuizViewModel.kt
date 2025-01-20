package com.example.guessthat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.guessthat.GameLogic.Question
import com.example.guessthat.GameLogic.QuizGame
import com.example.guessthat.data.Repository
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel: ViewModel(){

    lateinit var quizGame: QuizGame

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
    var scorePlayerOne by mutableIntStateOf(0)
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

    private val _time = MutableStateFlow("")
    var time = _time.asStateFlow()

    var questionNum by mutableStateOf("")
        private set


    private val _response = MutableStateFlow<String?>(null)
    val response: StateFlow<String?> = _response.asStateFlow()


    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    fun serverCheck()
    {
        viewModelScope.launch {
            val result = Repository.serverCheck()
            _response.value = result
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel() // Beende alle Coroutines
    }


    fun startQuiz(playerOne: String, playerTwo: String, gameType: String) {
        quizGame = QuizGame(playerOne, playerTwo, gameType)
        _gameType.value = quizGame.gameType
        updateScore()
        loadQuestion()
    }

    fun nextQuestion(): Boolean {
        return if (quizGame.goToNextQuestion()) {
            loadQuestion()
            true
        } else {
            false
        }
    }

    private fun loadQuestion() {
        val currentQuestion = quizGame.getCurrentQuestion()
        question = currentQuestion.question
        answer1 = currentQuestion.answer1.toString()
        answer2 = currentQuestion.answer2.toString()
        answer3 = currentQuestion.answer3.toString()
        answer4 = currentQuestion.answer4.toString()
        solution = currentQuestion.solution
        questionNum = (quizGame.currentQuestionIndex + 1).toString()
    }


    fun validateAnswer(player: String, buttonNum: Int, time: Float){
        if (answer1 == solution){
            _button1color.value = Color.Green
            _button2color.value = Color.Red
            _button3color.value = Color.Red
            _button4color.value = Color.Red

            if(buttonNum == 1)
            {
                quizGame.addToScore(player, time, "", solution)
                updateScore()
            }


        }
        else if (answer2 == solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Green
            _button3color.value = Color.Red
            _button4color.value = Color.Red

            if(buttonNum == 2)
            {
                quizGame.addToScore(player, time, "", solution)
                updateScore()

            }
        }
        else if (answer3 == solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Red
            _button3color.value = Color.Green
            _button4color.value = Color.Red

            if(buttonNum == 3)
            {
                quizGame.addToScore(player, time, "", solution)
                updateScore()

            }
        }
        else if (answer4 == solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Red
            _button3color.value = Color.Red
            _button4color.value = Color.Green

            if(buttonNum == 4)
            {
                quizGame.addToScore(player, time, "", solution)
                updateScore()

            }
        }
    }

    fun validateEstimation(player: String, guess: String, time: Float){
        if(guess.toIntOrNull() == null)
        {
            quizGame.addToScore(player, time, "100000000000", solution)
            updateScore()
        }
        else
        {
            quizGame.addToScore(player, time, guess, solution)
            updateScore()
        }
    }

    private fun updateScore()
    {
        scorePlayerOne = quizGame.scorePlayerOne
    }
}