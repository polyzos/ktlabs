package io.ipolyzos

fun main(args: Array<String>) {
    val circle = Circle(100, 100, 25)
    val point1 = Point(110, 110)
    val point2 = Point(10, 100)
    println(circle.contains(point1)) //true
    println(circle.contains(point2)) //false

    // injecting operators allows us to do
    println(point1 in circle)
    println(point2 in circle)
    println(circle contains point1)

    println("Circle Area is ${circle.area}")

    println()
    val str = "dad"
    println(str.isPalindrome())
    println(str.shout())



    println()

    // for-loop range must have an iterator() method
    for (word in "hell" .. "help") {
        print("$word, ")
    }

    println()
    val url: java.net.URL = String.toURL("https://pragprog.com")
    println(url)
}

/**
 * - explore injecting methods into existing classes first,
 * - then look into injecting an operator,
 * - followed by injecting a property.
 * */
data class Point(val x: Int, val y: Int)
data class Circle(val cx: Int, val cy: Int, val radius: Int)


/**
 * Injecting Methods using Extension Functions
 * */
// the classes above have no methods, but let's say we want to
// find if a point is located within a Circle
//fun Circle.contains(point: Point) =
//    (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) < radius * radius

/**
 * Injecting Operators using Extension Functions
 *   so mark the above with `operator`
 * */
infix operator fun Circle.contains(point: Point) =
    (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) < radius * radius


// Injecting Properties Using Extension Properties
val Circle.area: Double
    get() = kotlin.math.PI * radius * radius


// Injecting into Third-Party Classes
fun String.isPalindrome(): Boolean {
    return reversed() == this
}

fun String.shout() = uppercase()


// iterator for the for-loop
operator fun ClosedRange<String>.iterator() =
    object: Iterator<String> {
        private val next = StringBuilder(start)
        private val last = endInclusive

        override fun hasNext(): Boolean =
            last >= next.toString() && last.length >= next.length


        override fun next(): String {
            val result = next.toString()
            val lastCharacter = next.last()

            if (lastCharacter < Char.MAX_VALUE) {
                next.setCharAt(next.length - 1, lastCharacter + 1)
            } else {
                next.append(Char.MIN_VALUE)
            }
            return result
        }
    }


// Injecting Static Methods
fun String.Companion.toURL(link: String) = java.net.URL(link)