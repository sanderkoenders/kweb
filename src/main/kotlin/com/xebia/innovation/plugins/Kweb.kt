package com.xebia.innovation.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.websocket.*
import kweb.*
import kweb.state.KVar
import java.time.Duration

fun Application.kwebFeature() {
    install(DefaultHeaders)
    install(Compression)
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(10)
        timeout = Duration.ofSeconds(30)
    }

    install(Kweb)

    installKwebOnRemainingRoutes {
        doc.body.new {
            val greeting = url.map { it.removePrefix("/") }.map { "Hello " + if (it.isNotBlank()) it else "World" }

            val next = KVar("")

            h1().text(greeting)
            span().text("Where to next?")
            input().setValue(next)
            button().text("Go!").on.click {
                url.value = next.value
            }
        }
    }
}