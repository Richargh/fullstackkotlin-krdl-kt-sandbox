package messenger.backend

import io.javalin.Javalin
import messenger.shared.model.Message

fun main(args: Array<String>) {
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
}