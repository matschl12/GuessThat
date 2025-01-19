package com.example.guessthat.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.WebSockets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {
    companion object {
        private val client = HttpClient {
            install(WebSockets)
        }

        suspend fun serverCheck(): String? = withContext(Dispatchers.IO) {
            WebService.availableRequest(client)
        }

        suspend fun joinGeoGame(): String? = withContext(Dispatchers.IO) {
            WebService.joinGeoGame(client)
        }

        suspend fun joinSportsGame(): String? = withContext(Dispatchers.IO) {
            WebService.joinSportsGame(client)
        }

        suspend fun joinEstimationGame(): String? = withContext(Dispatchers.IO) {
            WebService.joinEstimationGame(client)
        }
    }
}