package com.example.guessthat.GameLogic



class QuizGame(player: String, gameType: String) {

    val questionz = getQuestions()
    val gameType = gameType
    var score = 0

    fun selectQuestions(): List<Question> {
        if (gameType == "Geo")
        {
            var selectedQuestions = questionz
                .filter{question -> question.id == "Geo"}
                .shuffled()
                .take(8)
            return selectedQuestions
        }
        else if (gameType == "Sport")
        {
            var selectedQuestions = questionz
                .filter{question -> question.id == "Sport"}
                .shuffled()
                .take(8)
            return selectedQuestions
        }
        else if (gameType == "Estimation")
        {
            var selectedQuestions = questionz
                .filter{question -> question.id == "Estimation"}
                .shuffled()
                .take(8)
            return selectedQuestions
        }
        else
            return questionz //should never be the case

    }

}

fun calculateScore(prevScore: Int, gameType: String, time: Float, guess: String, solution: String): Int {
    val actualTime = 8f - time

    if (gameType == "Geo" || gameType == "Sport") { //Formula: (1 - actualTime / 8) * 100           -> MAX 100 pts per round
        val calculation :Float = (1 - (actualTime/8)) * 100
        return (prevScore + calculation).toInt()
    } else if (gameType == "Estimation") { //Formula: ((answer / solution) * 100) * (1 - (actualTime / 8))          -> MAX 100 pts per round EXCEPT right guess then 100 bonus points

        val calculation :Float = (guess.toFloat() / solution.toFloat()) * 100
        val calculation2 :Float = 1 - (actualTime/8)

        if (calculation > 100.00 && calculation < 200.00) { //if guess is higher than solution BUT not double or more -> (200 - (answer / solution) * 100)) * (1 - (actualTime / 8))
            return (prevScore + (200 - calculation) * calculation2).toInt()
        }
        else if (calculation > 0.00 && calculation < 100.00) {
            return (prevScore + calculation * calculation2).toInt()
        }
        else if (calculation > 200.00)
        {
            return prevScore
        }
        else
        {
            return ((prevScore + calculation * calculation2)+100).toInt()    //100 Bonus points for getting the right guess
        }
    }
    return prevScore
}

fun addToScore()
{

}