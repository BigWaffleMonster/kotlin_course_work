package com.example.plugins

import com.example.handler.Handler
import com.example.types.Enroll
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(handler: Handler) {
    val handler = handler

    routing {
        post("/enroll"){
            val data = call.receive<Enroll>()
            val response = handler.createEnroll(data)

            call.respondText("$response")
        }

        get( "/enroll/{policy}") {
            val policy = call.parameters["policy"]
            print(policy!!.toInt())
            val qq = handler.getAllEnrolls(policy = policy!!.toInt())

            call.respond(qq)
        }

        delete("/enroll/{enroll_id}") {
            val enroll_id = call.parameters["enroll_id"]!!.toInt()
            val deleteOk = handler.removeEnroll(enroll_id)

            call.respond(deleteOk)
        }
    }
}
