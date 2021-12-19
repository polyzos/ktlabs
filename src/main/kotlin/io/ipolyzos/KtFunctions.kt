package io.ipolyzos

infix fun String.shouldBeEqualTo(value: String) = this == value

fun main(args: Array<String>) {

    // Infix Notation
    val output = "Hello"
    val result = output shouldBeEqualTo "Hello"
    println(result)


    // Anonymous Function
    val res = op(3) { it * it }
    println(res)
    val res1 = op(2, fun(x): Int { return x * x} )
    println(res1)


    // Inline functions
    operation { println("This is the actual op function") }
}


fun op(x: Int, op: (Int) -> Int): Int {
    return op(x)
}

// inline provides optimization
inline fun operation(op: () -> Unit) {
    println("Before calling op()")
    op()
    println("After calling op()")
}