package de.richargh.sandbox.fullstackkotlin.backend

import com.intuit.karate.junit5.Karate
import io.javalin.Javalin
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

class AppKarate {

    lateinit var app: Javalin

    @BeforeEach
    fun before(){
        app = runApp()
    }

    @AfterEach
    fun after(){
        app.stop()
    }

    @Karate.Test
    fun all() = Karate().relativeTo(javaClass)

}