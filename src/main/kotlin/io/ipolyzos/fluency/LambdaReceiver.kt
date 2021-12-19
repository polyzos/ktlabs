package io.ipolyzos

fun main() {
    lambdaWithReceiver()
}

fun lamda() {
    var length = 100

    // regular lambda
    val printIt: (Int) -> Unit = { n: Int ->
        println("n is $n, length is $length")
    }

    printIt(6)
}

fun lambdaWithReceiver() {
    var length = 100
//  The syntax String.(Int) says that the lambda will execute
    //  in the context of an instance of String.
    val printItWithReceiver: String.(Int) -> Unit = { n: Int ->
        println("n is $n, length is $length")
    }

    printItWithReceiver("Hello", 6)

    // The lambda acts like it’s an extension function for the receiver.
    // In fact, that’s exactly what Kotlin did. It treated the lambda as an extension function
    // of the receiver.
    "Hello".printItWithReceiver(6)


    // Whether we pass the receiver as a parameter or use it as a target of the call,
    // the this within the lambda now refers to the receiver passed instead of the lexical this.
}