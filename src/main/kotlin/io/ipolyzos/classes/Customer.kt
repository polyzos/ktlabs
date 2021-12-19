package io.ipolyzos.classes

import java.util.*

class Customer(val id: Int, var name: String = "", val yearOfBirth: Int) {
    val age: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth

    var socialSecurityNumber: String = ""
        set(value) {
            if (!value.startsWith("SN")) {
                throw IllegalArgumentException("Social security should start with SN")
            }
            field = value
        }

    init {
        name = name.uppercase()
    }

    constructor(email: String): this(0, "", 1992) {}
}

fun main(args: Array<String>) {
    val customer = Customer(10, "Hadi", 1973)

    customer.name
    customer.id

    println(customer.name)
    println(customer.age)
    println(customer.socialSecurityNumber)
}