package io.ipolyzos.arrow.fx

import arrow.fx.coroutines.*
import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val fiber = async {
        parZip({
            delay(100)
            throw RuntimeException("Boom")
        }, {
            guaranteeCase({
                never<Unit>()
            }) { exitCase -> println("I never complete: $exitCase") }
        }) { _, _ -> println("I am never called!") }
    }

    delay(200) // Wait until after task 1 threw
    fiber.await()
}