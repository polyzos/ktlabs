package io.ipolyzos.generics

open class Person

class Employee: Person()

fun operate(person: Array<Person>) {}

fun operate(person: List<Person>) {}


/**
 * INVARIANT TYPES
 *
 *  - GIVEN Employee and Person where
 *          Employee is subtype of Person
 *
 *    if Array<Employee> is NOT a subtype of Array<Person>
 *                  &
 *      Array<Person> is NOT a subtype of Array<Employee>
 *
 *   we say that the array is an invariant type
 * */
fun main() {
    val persons = arrayOf<Person>()
    val employees = arrayOf<Employee>()

    // i can do
    operate(persons)
    // but can't do
//    operate(employees)
    // invalid because Array<Employee> is NOT a subtype of Array<Person>

//    but it was a list, because lists are immutable and we can modify them
    val personsList = listOf<Person>()
    val employeesList = listOf<Employee>()

    operate(personsList)
    // This is now valid
    operate(employeesList)
}
