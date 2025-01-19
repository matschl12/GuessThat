package com.example.guessthat.Networking

import android.app.GameState
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.websocket.WebSocketSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class KtorRealtimemessagingClient(
    private val client: HttpClient
): RealtimeMessagingClient {

    private var session: WebSocketSession? = null

    override fun getGameStateStream(): Flow<GameState> {
        return flow {
            session = client.webSocketSession()

        }
    }

    override suspend fun close() {
        TODO("Not yet implemented")
    }
}