package com.xebia.innovation

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.xebia.innovation.plugins.*
import kweb.installKwebOnRemainingRoutes

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module, watchPaths = listOf("classes"))
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    kwebFeature()
}
