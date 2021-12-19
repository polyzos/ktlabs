package io.ipolyzos.arrow

import arrow.core.Either
import arrow.core.andThen

val throwsSomeStuff: (Int) -> Double = {x -> x.toDouble()}
val throwsOtherThings: (Double) -> String = {x -> x.toString()}
val moreThrowing: (String) -> List<String> = {x -> listOf(x)}
val magic = throwsSomeStuff
    .andThen(throwsOtherThings)
    .andThen(moreThrowing)

fun main() {
    println("magic = $magic")

    val right: Either<String, Int> = Either.Right(5)
    val left: Either<String, Int> = Either.Left("Something went wrong")

    println(right)
    println(left)

    println()

    println(parse("Not a number"))
    println(parse("2"))
}

fun parse(s: String) = if (s.matches(Regex("-?[0-9]+"))) Either.Right(s.toInt()) else Either.Left(NumberFormatException("$s is not a valid integer."))

fun reciprocal(i: Int) = if (i == 0) Either.Left(IllegalArgumentException("Cannot take reciprocal of 0.")) else Either.Right(1.0 / i)

fun stringify(d: Double): String = d.toString()