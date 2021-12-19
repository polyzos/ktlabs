package io.ipolyzos.dsl.models

object CastleDomain {
    data class Castle(var keep: Keep?, var towers: List<Tower>, var walls: List<Wall>)
    data class Keep(override val name: String): Connectable
    data class Tower(override val name: String): Connectable
    data class Wall(var from: Connectable, var to: Connectable)
}