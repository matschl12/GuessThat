// WebService.kt
package com.example.guessthat.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object WebService {
    suspend fun availableRequest(client: HttpClient): String? = withContext(Dispatchers.IO) {
        var response: String? = null
        try {
            client.webSocket("ws://10.0.2.2:8111/test") { // Special IP address because the emulator has his own localhost ip
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        response = frame.readText()
                        println("Received: $response")
                        break
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        response
    }

    suspend fun joinGeoGame(client: HttpClient): String? = withContext(Dispatchers.IO) {
        var response: String? = null
        try {
            client.webSocket("ws://10.0.2.2:8111/join/geo") { // Special IP address because the emulator has his own localhost ip
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        response = frame.readText()
                        println("Received: $response")
                        break
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        response
    }

    suspend fun joinSportsGame(client: HttpClient): String? = withContext(Dispatchers.IO) {
        var response: String? = null
        try {
            client.webSocket("ws://10.0.2.2:8111/join/sports") { // Special IP address because the emulator has his own localhost ip
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        response = frame.readText()
                        println("Received: $response")
                        break
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        response
    }

    suspend fun joinEstimationGame(client: HttpClient): String? = withContext(Dispatchers.IO) {
        var response: String? = null
        try {
            client.webSocket("ws://10.0.2.2:8111/join/estimation") { // Special IP address because the emulator has his own localhost ip
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        response = frame.readText()
                        println("Received: $response")
                        break
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        response
    }
}
