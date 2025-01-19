package com.example.guessthat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
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


    private val _response = MutableStateFlow<String?>(null)
    val response: StateFlow<String?> get() = _response


    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    fun serverCheck()
    {
        coroutineScope.launch(Dispatchers.IO) {
            _response.value = Repository.serverCheck()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel() // Beende alle Coroutines
    }

    var questionNum = 0
    var questionNumText by mutableStateOf(questionNum.toString())
        private set

    lateinit var quizGamez: QuizGame
    lateinit var quizQuestions: List<Question>
    lateinit var playerOne: String
    lateinit var playerTwo: String



    fun startQuiz(playerOne: String, gameType: String) {
        playerTwo = ""
        this.playerOne = playerOne
        quizGamez = QuizGame(playerOne, playerTwo, gameType)
        questionNum = quizGamez.questionNum
        scorePlayerOne = quizGamez.scorePlayerOne
        quizGamez.selectQuestions()
        quizQuestions = quizGamez.gameQuestions
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

    fun validateAnswer(player: String, buttonNum: Int, time: Float){
        if (quizQuestions[questionNum].answer1 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Green
            _button2color.value = Color.Red
            _button3color.value = Color.Red
            _button4color.value = Color.Red

            if(buttonNum == 1)
            {
                quizGamez.addToScore(player, time, "", solution)
                scorePlayerOne = quizGamez.scorePlayerOne
            }


        }
        else if (quizQuestions[questionNum].answer2 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Green
            _button3color.value = Color.Red
            _button4color.value = Color.Red

            if(buttonNum == 2)
            {
                quizGamez.addToScore(player, time, "", solution)
                scorePlayerOne = quizGamez.scorePlayerOne

            }
        }
        else if (quizQuestions[questionNum].answer3 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Red
            _button3color.value = Color.Green
            _button4color.value = Color.Red

            if(buttonNum == 3)
            {
                quizGamez.addToScore(player, time, "", solution)
                scorePlayerOne = quizGamez.scorePlayerOne

            }
        }
        else if (quizQuestions[questionNum].answer4 == quizQuestions[questionNum].solution){
            _button1color.value = Color.Red
            _button2color.value = Color.Red
            _button3color.value = Color.Red
            _button4color.value = Color.Green

            if(buttonNum == 4)
            {
                quizGamez.addToScore(player, time, "", solution)
                scorePlayerOne = quizGamez.scorePlayerOne

            }
        }
    }

    fun validateEstimation(player: String, guess: String, time: Float){
        if(guess.toIntOrNull() == null)
        {
            quizGamez.addToScore(player, time, "100000000000", solution)
            scorePlayerOne = quizGamez.scorePlayerOne
        }
        else
        {
            quizGamez.addToScore(player, time, guess, solution)
            scorePlayerOne = quizGamez.scorePlayerOne
        }
    }
}