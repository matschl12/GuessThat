package com.example.guessthat.GameLogic

class QuizGame(val playerOne: String, val playerTwo: String,  val gameType: String) {
    private val questions = getQuestions()
    var currentQuestionIndex = 0
    lateinit var gameQuestions: List<Question>
    var scorePlayerOne = 0
    var scorePlayerTwo = 0

    init {
        selectQuestions()
    }

    private fun selectQuestions() {
        gameQuestions = questions.filter { it.id == gameType }.shuffled().take(8)
    }

    fun getCurrentQuestion(): Question = gameQuestions[currentQuestionIndex]

    fun goToNextQuestion(): Boolean {
        return if (currentQuestionIndex + 1 < gameQuestions.size) {
            currentQuestionIndex++
            true
        } else {
            false // Keine weiteren Fragen
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