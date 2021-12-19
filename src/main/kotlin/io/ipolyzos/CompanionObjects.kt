package io.ipolyzos

class Log() {
    companion object Factory {
        fun createFileLog(filename: String) = Log(filename)
    }

    constructor(filename: String): this() {}
}

fun main(array: Array<String>) {
    val log = Log.createFileLog("filename.xt")
}