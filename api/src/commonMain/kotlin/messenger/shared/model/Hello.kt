package messenger.shared.model

class Hello {

    fun printHello() {
        println(hello())
    }

    fun hello(): String {
        return "Hello Kotlin!"
    }
}