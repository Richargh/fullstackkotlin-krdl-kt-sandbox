package de.richargh.sandbox.fullstackkotlin.frontend

import de.richargh.sandbox.fullstackkotlin.api.Hello
import kotlin.test.Test
import kotlin.test.assertEquals

class HelloTest {

    @Test
    fun helloTest() {
        val hello = Hello();
        assertEquals("Hello Kotlin!", hello.hello())
    }
}