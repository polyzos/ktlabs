package io.ipolyzos.inheritance


open class Person() {
    open fun validate() {}
}

open class Customer: Person() {
    final override fun validate() {

    }

//    constructor(): super() {}
}

class SpecialCustomer(): Customer() {

}
