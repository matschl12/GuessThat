package com.example.guessthat.GameLogic



class QuizGame(player: String, questions: List<Question>) {

    val geoQuestions = questions

    fun selectGeoQuestions(): List<Question> {
        var selectedQuestions = geoQuestions
            .shuffled()
            .take(8)

        return selectedQuestions
    }



}