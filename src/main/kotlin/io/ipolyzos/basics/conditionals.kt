package io.ipolyzos.basics

fun main(args: Array<String>) {
//    var myString = "Not Empty"
//
//    val result = if (myString != "") {
//        "A String"
//    } else {
//        "Another String"
//    }

    val result = "ValueN"
    val whenValue = when (result) {
        "Value" -> {
            println("It's a value")
            println("Second Statement")
            "v"
        }
        is String -> {
            println("Excellent")
            result
        }
        else -> {
            println("It came to this?")
            "n/a"
        }
    }
    println(whenValue)
}