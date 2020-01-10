package messenger.backend

import io.javalin.Javalin

fun main(args: Array<String>) {
    val app = Javalin.create { config ->
        config.addStaticFiles("public/")
    }.start(7000)

    app.get("/hi") {
        ctx -> ctx.result("Hello World")
    }
}