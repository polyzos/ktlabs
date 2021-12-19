package io.ipolyzos.meta

class Transaction(val id: Int, val amount: Double, var description: String) {
    fun validate() {
        if (amount > 10000) {
            println("io.ipolyzos.meta.Transaction is too large.")
        }
    }
}

fun introspectInstance(obj: Any) {
    println("Class ${obj.javaClass.simpleName}")
    println("Properties:")
    obj.javaClass.declaredFields.forEach {
        println("\t- ${it.name} of type ${it.type}")
    }
    println("\nFunctions:")
    obj.javaClass.declaredMethods.forEach {
        println("\t- ${it.name}")
    }
}

fun main() {
    introspectInstance(Transaction(1, 200.0, "A Simple Transaction"))
}