package io.ipolyzos.fluency

fun main() {
    println(Point2(1, -3))
    println(Point2(-3, 4))
}

class Point2(x: Int, y: Int) {
    private val pair = Pair(x, y)

    private val firstsign = if (pair.first < 0) "" else "+"
    private val secondsign = if (pair.second < 0) "" else "+"

    override fun toString(): String = pair.point2String()

    // Since the extension function is created within a class, it has two receivers:
    //  - this and this@Point.
    fun Pair<Int, Int>.point2String() =
        "(${firstsign}${first}, ${this@Point2.secondsign}${this.second})"
}