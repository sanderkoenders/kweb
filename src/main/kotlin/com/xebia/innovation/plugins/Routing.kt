package com.xebia.innovation.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/staticHello") {
            call.respondText("Hello World!")
        }
    }
    routing {
    }
}
