package io.ipolyzos.meta

//fun <T> printList(list: List<T>) {
//    when(list) {
//        is List<String> -> println("This is a list of Strings")
//        is List<Int> -> println("This is a list of Int")
//    }
//}

// you can only do
fun <T> printList(obj: T) {
    when (obj) {
        is Int -> println("This is an Int")
        is String -> println("This is a String")
    }
}

inline fun <reified T> erased(input: List<Any>, message: String) {
    if (input is T) {
        println(message)
    }
}
fun main() {
    val listString = listOf("One", "Two", "Three")
    val listNumbers = listOf(1, 2, 3)

    erased<List<String>>(listString, "Is String")
    erased<List<Int>>(listNumbers, "Is Int")
}