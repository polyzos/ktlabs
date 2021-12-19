package io.ipolyzos.basics

fun main(args: Array<String>) {
    for (a in 1 .. 10) {
        println(a)
    }

    val numbers = 1 .. 10
    for (a in numbers) {
        println(a)
    }

    for (a in 10 downTo 1) {
        println(a)
    }

    for (a in 10 .. 1) {
        println(a)
    }

    for (b in 10 downTo 1 step 2) {
        println(b)
    }
}