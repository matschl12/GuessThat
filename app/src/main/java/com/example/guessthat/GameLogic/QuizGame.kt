package com.example.guessthat.GameLogic



class QuizGame(player: String, gameType: String) {

    val questionz = getQuestions()
    val gameType = gameType

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