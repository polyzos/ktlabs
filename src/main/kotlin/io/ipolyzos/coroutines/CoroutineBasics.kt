package io.ipolyzos.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(100000) {
        launch {
            delay(5000L)
            print(".")
        }
    }
}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

suspend fun doWorldWithCoroutineScope() = coroutineScope {
    launch { doWorld() }
}