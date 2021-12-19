package io.ipolyzos

fun top(func: String.() -> Unit) = "hello".func()

fun nested(func: Int.() -> Unit) = (-2).func()

fun main() {
    top {
        println("In outer lambda $this and $length")

        nested {
            println("in inner lambda $this and ${toDouble()}")
            println("from inner through receiver to outer: $length")
            println("from inner to outer receiver ${this@top}")
        }
    }
}