package io.ipolyzos.basics

fun printStrings(vararg strings: String) {
    reallyPrintingString(*strings)
}

private fun reallyPrintingString(vararg strings: String) {
    for (string in strings) {
        println(string)
    }
}

fun main(args: Array<String>) {
    printStrings("1")
    printStrings("1", "2", "3", "4", "5")
}