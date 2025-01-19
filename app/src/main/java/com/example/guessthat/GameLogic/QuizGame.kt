package com.example.guessthat.GameLogic

import kotlin.properties.Delegates


class QuizGame(val playerOne: String, val playerTwo: String, gameType: String) {
    val questionz = getQuestions()
    lateinit var gameQuestions : List<Question>
    val gameType = gameType
    var scorePlayerOne = 0
    var scorePlayerTwo = 0
    var questionNum = 0

    fun selectQuestions() {
        if (gameType == "Geo")
        {
            var selectedQuestions = questionz
                .filter{question -> question.id == "Geo"}
                .shuffled()
                .take(8)
            gameQuestions = selectedQuestions
        }
        else if (gameType == "Sport")
        {
            var selectedQuestions = questionz
                .filter{question -> question.id == "Sport"}
                .shuffled()
                .take(8)
            gameQuestions = selectedQuestions
        }
        else if (gameType == "Estimation")
        {
            var selectedQuestions = questionz
                .filter{question -> question.id == "Estimation"}
                .shuffled()
                .take(8)
            gameQuestions = selectedQuestions
        }

    }

    fun addToScore(player: String, time: Float, guess: String, solution: String) {
        val actualTime = 8f - time

        if (gameType == "Geo" || gameType == "Sport") { //Formula: (1 - actualTime / 8) * 100           -> MAX 100 pts per round
            val calculation :Float = (1 - (actualTime/8)) * 100
            scorePlayerOne =   (scorePlayerOne + calculation).toInt()
        } else if (gameType == "Estimation") { //Formula: ((answer / solution) * 100) * (1 - (actualTime / 8))          -> MAX 100 pts per round EXCEPT right guess then 100 bonus points

            val calculation :Float = (guess.toFloat() / solution.toFloat()) * 100
            val calculation2 :Float = 1 - (actualTime/8)

            if (calculation > 100.00 && calculation < 200.00) { //if guess is higher than solution BUT not double or more -> (200 - (answer / solution) * 100)) * (1 - (actualTime / 8))
                scorePlayerOne =  (scorePlayerOne + (200 - calculation) * calculation2).toInt()
            }
            else if (calculation > 0.00 && calculation < 100.00) {
               scorePlayerOne = (scorePlayerOne + calculation * calculation2).toInt()
            }
            else if (calculation > 200.00)
            {
                scorePlayerOne = scorePlayerOne
            }
            else
            {
                scorePlayerOne =   ((scorePlayerOne + calculation * calculation2)+100).toInt()    //100 Bonus points for getting the right guess
            }
        }

    }

}

fun startSinglePlayerQuiz(player: String, gameType: String) {
    val quizGame = QuizGame(player, "", gameType)
    val questions = quizGame.selectQuestions()


}
