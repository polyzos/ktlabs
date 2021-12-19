package io.ipolyzos.generics

/**
 *  List<T> is covariant when:
 *      Employee is subtype of Person
 *              &
 *      List<Employee> is subtype of List<Person>
 *
 *  Then:
 *      - Values are passed out <- produced instead of consumed
 *      - Declaration-site to indicate covariance
 *          - via out modifier
 *          - similar to ? extends T in Java
 * */

open class CPerson
class CEmployee: CPerson()

fun operate(person: List<CPerson>) {}

// we can use out because it only reads, doesnt modify state
interface ReadOnlyRepo<out T> {
    fun getId(id: Int): T
    fun getAll(): List<T>
}

class ReadOnlyRepoImpl<out T>: ReadOnlyRepo<T> {
    override fun getId(id: Int): T {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<T> {
        TODO("Not yet implemented")
    }

}
fun main() {
    operate(listOf<CEmployee>())
    operate(listOf<CPerson>())

    val ro = ReadOnlyRepoImpl<CEmployee>()
    ro.getAll()
    ro.getId(1)
}