package com.example.guessthat.Networking

import android.net.http.HttpEngine
import io.ktor.client.HttpClient

fun createHttpClient(engine: HttpEngine): HttpClient{
    return HttpClient()
}