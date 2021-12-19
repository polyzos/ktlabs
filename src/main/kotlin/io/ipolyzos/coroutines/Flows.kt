package io.ipolyzos.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
//    simple().forEach(::println)
    runBlocking {
        simpleSuspended().forEach(::println)
    }
}

// blocks the main thread
fun simple(): Sequence<Int> = sequence {
    for (i in 1..1000) {
        Thread.sleep(100)
        yield(i)
    }
}

suspend fun simpleSuspended(): List<Int> {
    delay(1000)
    return (1 until 1000).toList()
}