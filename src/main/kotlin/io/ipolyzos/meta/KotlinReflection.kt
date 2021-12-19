package io.ipolyzos.meta

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

fun getKotlinType(obj: KClass<*>) {
    println(obj.qualifiedName)
}

fun main() {
    val classInfo = Transaction::class

     classInfo.memberProperties.forEach {
         println("Property ${it.name} of type ${it.returnType}")
     }

    println()
    classInfo.constructors.forEach {
        println("Constructor ${it.name} - ${it.parameters}")
    }

    println(Transaction::class)

    println()
    // grab the constructor
    val constructor = ::Transaction
    println(constructor)

    val transaction = constructor.call(1, 2000, "Some description")
    println(transaction.description)
}