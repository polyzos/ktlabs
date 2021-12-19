package io.ipolyzos.rocksdb

import io.ipolyzos.models.ClickEvent
import io.ipolyzos.utils.FileUtils
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.rocksdb.Options
import org.rocksdb.RocksDB
import java.io.File
import java.nio.file.Files

fun main() {
    RocksDB.loadLibrary()

    val options: Options = Options()
    options.setCreateIfMissing(true)

    val dbName = "testdb"
    val dbDirectory = File("rocksdb_state_store/", dbName)

    Files.createDirectories(dbDirectory.parentFile.toPath())
    Files.createDirectories(dbDirectory.absoluteFile.toPath())
    val rocksDB = RocksDB.open(options, dbDirectory.absolutePath)

    rocksDB.dbOptions.build().toString().split(";")
        .forEach(::println)

    val events = FileUtils
        .readFile("events.csv")
        .take(10)

    println(events.size)

    println(
        events.map { it.userSession }.distinct().size
    )

    println(
        events.map { it.userId }.distinct().size
    )

    events.forEach { event ->
        val userId = event.userId
        val str = Json.encodeToString(event)
        put(userId.toString().toByteArray(), str.toByteArray(), rocksDB)
    }
    println("Added all events")
    Thread.sleep(2000L)

    events.forEach { event ->
        val id = event.userId.toString().toByteArray()
        val data = get(id, rocksDB)
        println("${data != null} - data: ${data?.let { String(it) }?.let { Json.decodeFromString<ClickEvent>(it) }}")
    }

    println("Lookup All Records")
    Thread.sleep(2000L)
    events.forEach { event ->
        val id = event.userId.toString().toByteArray()
        delete(id, rocksDB)
    }

    events.forEach { event ->
        val id = event.userId.toString().toByteArray()
        val data = get(id, rocksDB)
        println("${data != null} - data: ${data}")
    }
    println("Deleted All Records")
    rocksDB.close()
}

fun put(key: ByteArray, value: ByteArray, rocksDB: RocksDB) {
    rocksDB.put(key, value)
}

fun get(key: ByteArray, rocksDB: RocksDB): ByteArray? {
    return rocksDB.get(key)
}

fun delete(key: ByteArray, rocksDB: RocksDB) {
    rocksDB.delete(key)
}