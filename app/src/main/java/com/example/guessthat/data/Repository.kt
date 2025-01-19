package com.example.guessthat.data

import com.example.guessthat.GameLogic.Question
import io.ktor.client.statement.HttpResponse

class Repository() {
    companion object {
        //suspend fun getQuestions(): List<Question>? = questionRequest() //to get questions from server
        suspend fun serverCheck(): String? = availableRequest(client) //to check if server is running

    }
}