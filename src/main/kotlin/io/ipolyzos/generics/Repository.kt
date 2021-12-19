package io.ipolyzos.generics

import java.io.Serializable


open class Entity(val id: Int)

// put an upper bound on Entity - here i only have one restriction
class Repository<T : Entity> {
    fun save(entity: T) {
        if (entity.id != 0) {
            //
        }
    }
}


// if i have multiple restrictions i can do
class RepositoryMultipleRestrictions<T> where T: Entity,T: Serializable {
    fun save(entity: T) {
        if (entity.id != 0) {
            //
        }
    }
}

class CustomerEntity(id: Int) : Entity(id)

fun main() {
    val repo = Repository<CustomerEntity>()
}


// we can restrict functions as well
fun <T: Serializable> streamObject(obj: T) {

}