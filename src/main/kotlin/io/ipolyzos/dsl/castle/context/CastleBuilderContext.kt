package io.ipolyzos.dsl.context

import io.ipolyzos.dsl.models.CastleDomain
import io.ipolyzos.dsl.models.Connectable
import io.ipolyzos.dsl.models.StringSymbolTable

fun main(args: Array<String>) {
    CastleDSL().build()
}

class CastleDSL {
    fun build() {
        val builder = CastleBuilder()

        // with context variable
        builder.start("sw").to("nw").to("ne").to("se")

        // using new context variable, for tracking which to start from
        builder.fix("keep")
            .fixTo("sw")
            .fixTo("nw")
            .fixTo("ne")
            .fixTo("se")

        // context function using partial application
        val to = builder.connectFrom("keep")
        to("sw")
        to("nw")
        to("ne")
        to("se")
    }
}

class CastleBuilder {
    var towers = mutableListOf<CastleDomain.Tower>()
    var keep: CastleDomain.Keep? = null
    var last: String? = null
    private var connections = mutableMapOf<String, String>()

    fun start(from: String): CastleBuilder {
        last = from
        return this
    }

    fun to(to: String): CastleBuilder {
        last?.let { connect(it, to) }
        last = to
        return this
    }

    fun fix(from: String): CastleBuilder {
        last = from
        return this
    }

    fun fixTo(to: String): CastleBuilder {
        last?.let { connect(it, to) }
        return this
    }

    fun connectFrom(from: String): (String) -> CastleBuilder {
        return { to: String -> connect(from, to) }
    }

    fun connect(from: String, to: String): CastleBuilder {
        connections[from] = to
        return this
    }

    fun build(): CastleDomain.Castle {
        val symbols = StringSymbolTable<Connectable>()
        towers.forEach { symbols.add(it.name, it) }
        keep?.let { symbols.add(it.name, it) }

        val allWalls = connections.map { (from, to) ->
            CastleDomain.Wall(symbols.lookup(from), symbols.lookup(to))
        }
        return CastleDomain.Castle(keep, towers, allWalls)
    }
}