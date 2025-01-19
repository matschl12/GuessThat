package com.example.guessthat.data

import com.example.guessthat.GameLogic.Question
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.concurrent.Flow


val client = HttpClient {
    install(WebSockets)
}

suspend fun availableRequest(client: HttpClient): String? {
    var response = ""
    try {
        client.webSocket("ws://127.0.0.1:8111/test") {
            println("Connected")

            for (frame in incoming) {
                when (frame) {
                    is Frame.Text -> {
                       response = frame.readText()
                        println("Received: $response")
                    }
                    else -> println("Received unsupported frame: $frame")
                }
            }
        }
    } catch (e: Exception) {
        println("An error occured: ${e.message} ")
        return "Keine Verbindung zum Server"
    } finally {
        client.close()
        println("Client closed")
    }
    return response + "ist so geil"
}



/*
//check for server
suspend fun availableRequest(): String? {
    try{
        val response: HttpResponse = client.get("$SERVERADDRESS/test"){
            contentType(ContentType.Application.Json)
        }
        println(response.status)
        if (response.status == HttpStatusCode.OK)
        {
            println(response.bodyAsText())
        }
        return Json.decodeFromString(response.toString())
    }
    catch (e: Exception) {
        println("Request failed:  ${e.message}")
    }
    return null
}

suspend fun questionRequest(): List<Question>? {
    try {
        val response = client.get("${SERVERADDRESS}/questions") {
            contentType(ContentType.Application.Json)
        }
        println(response.status)
        if (response.status == HttpStatusCode.OK)
        {
            println(response.bodyAsText())
        }
        return Json.decodeFromString(response.toString())
    } catch (e: Exception) {
        println("Request failed: ${e.message}")
    }
    return null
}
 */
