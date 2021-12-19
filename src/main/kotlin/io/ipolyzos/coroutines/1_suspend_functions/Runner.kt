package io.ipolyzos.coroutines.`1_suspend_functions`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 2 Core concepts:
 *  - Coroutine builders
 *  - Suspending Functions
 * */
fun old_main() {

    GlobalScope.launch {
        // delay doesnt block the main thread
        // it suspends the coroutine, the thread can continue the work
        // and then continue
        delay(1000)
        println("World")
    }
    print("Hello, ")
    Thread.sleep(1500)

    println("\n--- runBlocking part ---\n")
    // runBlocking will block the main thread
    // until the code is finished
    GlobalScope.launch {
        delay(1000)
        println("World")
    }
    print("Hello, ")
    runBlocking {
       delay(1500)
    }
}

fun main() {
    runBlocking {
        launch {
            delay(1000)
            println("World")
        }
        print("Hello, ")
        delay(1500)
    }
}