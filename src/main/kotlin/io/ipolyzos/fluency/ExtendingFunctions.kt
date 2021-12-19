package io.ipolyzos

// Book page: 234
fun main() {
    fun increment(number: Int): Double = number + 1.toDouble()
    fun double(number: Double) = number * 2

    val incrementAnDouble = ::increment.andThen(::double)
    println(incrementAnDouble(5))
}

fun <T, R, U> ((T) -> R).andThen(next: (R) -> U): (T) -> U = {
    input: T -> next(this(input))
}