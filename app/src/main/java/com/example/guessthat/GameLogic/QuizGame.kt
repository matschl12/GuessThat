package com.example.guessthat.GameLogic



class QuizGame(player: String, questions: Array<Questions>) {

    var abcSelectedQuestions = questions

    fun selectGeoQuestions(): Array<Questions>{
        var selectedQuestions = abcSelectedQuestions.toList()
            .shuffled()
            .take(8)
            .toTypedArray()

        return selectedQuestions
    }



}