package io.ipolyzos.coroutines.`2_structured_concurrency`

import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Launch a number of coroutines, using a different dispatcher
 *  within the coroutine print out the name of the thread we are running on
 *  see which thread is being used for this particular coroutine
 * */

//val scope = CoroutineScope(Job())
val dispatcher: ExecutorCoroutineDispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
val executor: ExecutorService = Executors.newFixedThreadPool(5)

fun main() = runBlocking {
    val jobs = arrayListOf<Job>()

    // Using dispatchers defined in the library
    jobs += launch { // the 'default' context
        println("\t'default:' In thread ${Thread.currentThread().name}.")
    }

    jobs += launch(Dispatchers.Default) { // the 'default' context
        println("\t'defaultDispatcher:' In thread ${Thread.currentThread().name}.")
    }

    jobs += launch(Dispatchers.IO) { // the 'IO' context
        println("\t'IO Dispatcher:' In thread ${Thread.currentThread().name}.")
    }

    jobs += launch(Dispatchers.Unconfined) { // the 'not confined' -- will work with the main thread
        println("\t'Unconfined:' In thread ${Thread.currentThread().name}.")
    }

    jobs += launch(newSingleThreadContext("OwnThread")) { // will get its own new thread
        println("\t'newSTC:' In thread ${Thread.currentThread().name}.")
    }

    // Use our own dispatchers
    jobs += launch(dispatcher) { // will get dispatched to ForkJoinPool.commonPool (or equivalent)
        println("\t'cachedThreadPool:' In thread ${Thread.currentThread().name}.")
    }

    jobs += launch(executor.asCoroutineDispatcher()) { // will get dispatched to ForkJoinPool.commonPool (or equivalent)
        println("\t'fixedThreadPool:' In thread ${Thread.currentThread().name}.")
    }


    jobs.forEach { it.join() }

    println()
    println()
    println()
    executor.shutdown()
    dispatcher.close()
}