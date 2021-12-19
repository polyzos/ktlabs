package io.ipolyzos.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * Coroutines need to run in a Scope
 * */
fun main() {
    GlobalScope.launch {
        // use delay instead of Thread.sleep
        delay(1000)
        print("World")
    }

    print("Hello, ")
    Thread.sleep(1500)
}