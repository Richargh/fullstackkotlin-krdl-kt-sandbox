package de.richargh.sandbox.reactkt

import messenger.shared.model.Hello
import messenger.shared.model.Message
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.fetch.RequestInit
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.json

fun main(args: Array<String>) {
    Hello().printHello()

    val userSelect = document.getElementById("user-select") as HTMLSelectElement
    val messageInput = document.getElementById("message-input") as HTMLInputElement
    val submitButton = document.getElementById("submit-button") as HTMLInputElement

    messageInput.onkeypress =  {
        if (it.keyCode == 13 && messageInput.checkValidity()) {
            submit(Message(userSelect.value, messageInput.value))
            messageInput.value = ""
            it.preventDefault()
        }
    }

    submitButton.onclick =  {
        if (messageInput.checkValidity()) {
            submit(Message(userSelect.value, messageInput.value))
            messageInput.value = ""
        }
    }

    document.bgColor = "FFAA12"
}

fun submit(message: Message) {
    window.fetch("/message", init = RequestInit(
            method = "POST",
            headers = json("Content-Type" to "application/json"),
            body = JSON.stringify(message))).then { response ->
        response.json()
    }.then { json ->
        val li = document.createElement("li").apply {
            innerHTML = "<b>${json.asDynamic().Sup}</b>"
        }
        document.getElementById("messages")!!.appendChild(li)
    }
}