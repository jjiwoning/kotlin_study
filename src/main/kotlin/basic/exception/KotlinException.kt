package basic.exception

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val num1 = parseInt("12314")
    val num2 = parseInt2("asdas")
    println(num2)
}

/**
 * try catch
 */
fun parseInt(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("$str is not number")
    }
}

/**
 * Kotlin의 try catch는 expression
 */
fun parseInt2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

/**
 * Kotlin은 Checked Exception과 UnChecked Exception을 구분하지 않는다.
 */
fun readLine(): String? {
    val br = BufferedReader(InputStreamReader(System.`in`)) // throws가 없다
    return br.readLine()
}

/**
 * try with resources in Kotlin
 */
fun readLine2(): String? {
    BufferedReader(InputStreamReader(System.`in`)).use {it ->
        return it.readLine()
    }
}
