package com.example.guessthat.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.WebSockets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object Repository {
    private val client = HttpClient {
        install(WebSockets)
    }

    suspend fun serverCheck(): String? = withContext(Dispatchers.IO) {
        WebService.availableRequest(client)
    }
}