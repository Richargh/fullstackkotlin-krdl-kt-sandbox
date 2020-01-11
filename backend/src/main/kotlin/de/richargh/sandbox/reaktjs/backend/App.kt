package de.richargh.sandbox.reaktjs.backend

import de.richargh.sandbox.reaktjs.api.Message
import io.javalin.Javalin

fun runApp(): Javalin {
    val app = Javalin.create { config ->
        config.addStaticFiles("public/")
    }.start(7000)

    app.get("/hi") { ctx ->
        ctx.result("Hello World")
    }

    app.post("/message"){ ctx ->
        val message = ctx.bodyAsClass(Message::class.java)
        println("New message $message")
        ctx.result("""{"Sup": "${message.content}"} """)
    }
    return app
}