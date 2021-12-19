package io.ipolyzos.dsl.castle.buildercontext

fun main(args: Array<String>) {
    println("start")
    TempDSL().runDSL()
}

class TempDSL {
    fun runDSL() {
        val temp = TempBuilder().current()
            .toF().addF(10.0f)
            .toC().addC(10.0f)
            .toF().addF(10.0f).build()

        println("final temp ${temp.current}")
        println()
        TempBuilder().current().toF().addF(10.0f)
        TempBuilder().current().toC().addC(10.0f)

        TempBuilder().current().toF().addF(10.0f)
            .toC()
            .addC(10.0f)
        println("final temp ${temp.current}")
    }
}

class Temp(var current: Float = 10.0f) {
    fun add(amount: Float) {
        current += amount
        println("Temp is now: $current")
    }

    fun convertToC() {
        current = (current - 33) * .5556f
    }

    fun convertToF() {
        current = (current * .5556f) + 32
    }
}

// builders
open class TempBuilder(var temp: Temp = Temp()) {
    fun current(): TempBuilderImmutable {
        temp.current = 20.0f
        println("current temp is now: ${temp.current}")
        return TempBuilderImmutable(temp)
    }

    fun toF() : TempBuilderFahrenheit {
        temp.convertToF()
        return TempBuilderFahrenheit(temp)
    }
    fun toC() : TempBuilderCelsius {
        temp.convertToC()
        return TempBuilderCelsius(temp)
    }
    fun build() : Temp {
        return temp
    }
}

class TempBuilderImmutable(temp: Temp): TempBuilder(temp)

class TempBuilderFahrenheit(temp: Temp) : TempBuilder(temp) {
    fun addF(amount: Float) : TempBuilderFahrenheit {
        temp.add(amount)
        return this
    }
}

class TempBuilderCelsius(temp: Temp) : TempBuilder(temp) {
    fun addC(amount: Float) : TempBuilderCelsius {
        temp.add(amount)
        return this
    }
}