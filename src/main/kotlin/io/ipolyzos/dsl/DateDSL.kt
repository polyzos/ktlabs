package io.ipolyzos.dsl

import java.util.*
import io.ipolyzos.dsl.DateUtil.Tense.*

fun main() {

    val yesterday = 1 day ago
    println(yesterday)

    val tomorrow = 1 day from_now
    println(tomorrow)
}

infix fun Int.day(timing: DateUtil.Tense) = DateUtil(this, timing)

class DateUtil(val number: Int, val tense: Tense) {
    enum class Tense {
        ago, from_now
    }

    override fun toString(): String {
        val today = Calendar.getInstance()

        when (tense) {
            ago -> today.add(Calendar.DAY_OF_MONTH, -number)
            from_now -> today.add(Calendar.DAY_OF_MONTH, number)
        }
        return today.time.toString()
    }
}