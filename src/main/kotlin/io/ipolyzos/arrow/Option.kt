package io.ipolyzos.coroutines

import arrow.core.*
import arrow.core.computations.option


suspend fun main() {

    // Option -> missing values
    val value1 = maybeWillReturnSomething(true)
    println(value1)

    val value2 = maybeWillReturnSomething(false)
            .getOrElse { "No value" }
    println(value2)

    val value = when(value1) {
        is Some -> value1.value
        is None -> "Nothing found"
        else -> "?? case"
    }
    println("value = $value")

    val number: Option<Int> = Some(3)
    val noNumber: Option<Int> = None
    val mappedResult1 = number.map { it * 1.5 }
    val mappedResult2 = noNumber.map { it * 1.5 }

    println("number = $number")
    println("noNumber = $noNumber")
    println("mappedResult1 = $mappedResult1")
    println("mappedResult2 = $mappedResult2")

    val fold = Some(3).fold({ 1 }, { it * 3 })
    println(fold)

    val fold2 = none<Int>().fold({ 1 }, { it * 3 })
    println(fold2)

    val bindResult = option {
        val a = Some(1).bind()
        val b = Some(1 + a).bind()
        val c = Some(1 + b).bind()
        a + b + c
    }
    println(bindResult)

    val bindResultWithNone = option {
        val x = none<Int>().bind()
        val y = Some(1 + x).bind()
        val z = Some(1 + y).bind()
        x + y + z
    }
    println(bindResultWithNone)
}

fun maybeWillReturnSomething(flag: Boolean): Option<String> =
    if (flag) Some("Found Value") else None