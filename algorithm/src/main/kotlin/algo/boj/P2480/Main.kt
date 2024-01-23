package algo.boj.P2480

import kotlin.math.max

fun main(args: Array<String>) {
    val (d1, d2, d3) = readln().split(" ").map { it.toInt() }

    if (d1 == d2 && d2 == d3) {
        println(10000 + 1000 * d1)
        return
    }

    if (d1 == d2) {
        println(1000 + 100 * d1)
        return
    }

    if (d2 == d3) {
        println(1000 + 100 * d2)
        return
    }

    if (d1 == d3) {
        println(1000 + 100 * d1)
        return
    }

    println(100 * max(d1, max(d2, d3)))
}