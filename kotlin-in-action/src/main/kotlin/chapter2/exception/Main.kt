package chapter2.exception

import java.io.BufferedReader

fun main() {

    val number = Math.random().toInt()

    val percentage = if (number in 0..100) number else throw IllegalArgumentException()
}

fun readNum(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return line.toInt()
    } catch (e: NumberFormatException) {
        e.printStackTrace()
        return null
    } finally {
        reader.close()
    }
}

fun readNumber(reader: BufferedReader) {
    val number = try {
        reader.readLine().toInt()
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}
