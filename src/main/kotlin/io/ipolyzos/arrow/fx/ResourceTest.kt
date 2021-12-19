package io.ipolyzos.arrow.fx

import arrow.fx.coroutines.release
import arrow.fx.coroutines.resource


class UserProcessor {
    fun start() = println("Creating UserProcessor")
    fun shutdown() = println("Shutting down UserProcessor")
    fun process(ds: DataSource): List<String> = ds.users().map { "Processed $it"}
}

class DataSource {
    fun connect() = println("Connecting dataSource")
    fun users() = listOf("User-1", "User-2", "User-3")
    fun close() = println("Closed dataSource")
}

class Service(val db: DataSource, val userProcessor: UserProcessor) {
    suspend fun processData(): List<String> = userProcessor.process(db)
}

suspend fun main() {
    val userProcessor = resource {
        UserProcessor().also(UserProcessor::start)
    } release UserProcessor::shutdown

    val dataSource = resource {
        DataSource().also { it.connect() }
    } release DataSource::close

    userProcessor.parZip(dataSource) { userProcessor, ds ->
        Service(ds, userProcessor)
    }.use { service -> service.processData() }
}