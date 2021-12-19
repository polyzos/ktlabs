package io.ipolyzos.classes

enum class Priority {
    MINOR,
    NORMAL,
    MAJOR,
    CRITICAL
}

enum class PriorityWithValue(val value: Int) {
    MINOR(-1) {
        override fun text(): String {
            TODO("Not yet implemented")
        }
    },
    NORMAL(0) {
        override fun text(): String {
            TODO("Not yet implemented")
        }
    },
    MAJOR(1) {
        override fun text(): String {
            TODO("Not yet implemented")
        }
    },
    CRITICAL(10) {
        override fun text(): String {
            TODO("Not yet implemented")
        }
    };

    abstract fun text(): String
}
fun main(args: Array<String>) {
    val priority = Priority.NORMAL
    println(priority)

    val priority2 = PriorityWithValue.NORMAL
    println(priority2.value)
}