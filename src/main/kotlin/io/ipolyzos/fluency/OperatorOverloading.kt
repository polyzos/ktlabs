package io.ipolyzos

import kotlin.math.abs

fun main(args: Array<String>) {

    val pair1 = Pair<Int, Int>(1, 2)
    val pair2 = Pair<Int, Int>(2, 1)

    val pairResult = pair1 + pair2
    println(pairResult)

    println(Complex(4, 2) * Complex(-3, 4))
    println(Complex(1, 2) * Complex(-3, 4))

    var counter = Counter(2)
    println(counter)
    println(++counter)
    println(counter)
    println(counter++)
    println(counter)
    println(counter--)
    println(counter)
    println(--counter)
    println(counter)
}

operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>) =
    Pair(first + other.first, second + other.second)

data class Complex(val real: Int, val imaginary: Int) {

    // overload to allow for `*`
    operator fun times(other: Complex) =
        Complex(
            real * other.real - imaginary * other.imaginary,
            real * other.imaginary + imaginary * other.real
        )

    private fun sign() = if (imaginary < 0) "-" else "+"

    override fun toString(): String =
        "$real ${sign()} ${abs(imaginary)}i"

}

class Counter(val value: Int) {
    // add operators to support x++ and ++x
    operator fun inc() = Counter(value + 1)

    operator fun dec() = Counter(value - 1)

    override fun toString(): String = "${value}"
}