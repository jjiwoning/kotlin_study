package algo.boj.P1484

import java.util.TreeSet
import kotlin.math.pow

fun main() {
    val n = readLine()?.toLong()!!

    val answer = TreeSet<Int>()
    val table = LongArray(100001) { 0L }

    for (i in 1 until table.size) {
        table[i] = i.toDouble().pow(2).toLong()
    }

    var start = 1
    var end = 2

    while (start < end) {
        val diff = table[end] - table[start]
        if (diff > n) {
            start++
        }
        if (diff < n) {
            end++
        }
        if (diff == n) {
            answer.add(end)
            end++
        }
    }

    if (answer.isEmpty()) {
        println(-1)
        return
    }

    val result = StringBuilder()
    for (num in answer) {
        result.append(num).append("\n")
    }
    println(result)
}
