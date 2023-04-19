package algo.boj.P2420

import kotlin.math.abs

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    println(abs(a - b))
}