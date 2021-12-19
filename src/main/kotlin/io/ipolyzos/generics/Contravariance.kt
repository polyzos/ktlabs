package io.ipolyzos.generics

/**
 *  Structure<T> is contravariant when:
 *      Employee is subtype of Person
 *              &
 *      Structure<Person> is subtype of Structure<Employee>
 *
 *  Then:
 *      - Values are passed in <- consumed instead of produced
 *      - Declaration-site to indicate contravariance
 *          - via in modifier
 *          - similar to ? super T in Java
 * */

// use in because we modify it
interface WriteRepo<in T> {
    fun save(obj: T)
    fun saveAll(list: List<T>)
}

class WriteRepoImpl<in T>: WriteRepo<T> {
    override fun save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }
}

fun main() {

}