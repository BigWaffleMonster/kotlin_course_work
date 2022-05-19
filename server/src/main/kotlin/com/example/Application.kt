package com.example

import com.example.handler.Handler
import com.example.plugins.configureHTTP
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import com.example.repository.Database
import com.example.repository.Repository
import com.example.service.Service
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
  val db = Database().connect()

  val repository = Repository(db)
  val service = Service(repository)
  val handler = Handler(service)

  embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
    configureHTTP()
    configureRouting(handler)
    configureSerialization()
  }.start(wait = true)
}
