package de.richargh.sandbox.reactkt.frontend

import de.richargh.sandbox.reaktjs.api.Hello
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloTest {

    @Test
    fun helloTest() {
        val hello = Hello();
        assertEquals("Hello Kotlin!", hello.hello())
    }
}