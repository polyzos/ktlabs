package io.ipolyzos.utils

import io.ipolyzos.models.ClickEvent
import java.io.File
import java.sql.Timestamp

object FileUtils {

    fun readFile(path: String): List<ClickEvent> {
        return File(path).useLines { lines ->
            lines.drop(1)
                .map { strToEvent(it) }
                .toList()
        }
    }

    private fun strToEvent(line: String): ClickEvent {
        val tokens = line.split(",")
        return ClickEvent(
            Timestamp.valueOf(tokens[0].replace(" UTC", "")).time / 1000,
            tokens[1],
            tokens[2].toLong(),
            tokens[3].toLong(),
            tokens[4],
            tokens[5],
            tokens[6],
            tokens[7].toLong(),
            tokens[8])
    }
}