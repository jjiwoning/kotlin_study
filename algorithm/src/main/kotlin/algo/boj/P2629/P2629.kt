package algo.boj.P2629

import kotlin.math.abs

private var n = 0
private lateinit var weights: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    weights = readLine().split(" ")
        .map { it.toInt() }
        .toIntArray()

    val m = readLine().toInt()

    val marbles = readLine().split(" ")
        .map { it.toInt() }
        .toIntArray()

    weights.sortDescending()

    val dp = Array(n + 1) {IntArray(40001) { 0 } }

    dp[0][0] = 1

    for (i in 1..n) {
        dp[i][weights[i - 1]] += 1
        for (j in 0..40000) {
            dp[i][j] += dp[i - 1][j]
            dp[i][abs(j - weights[i - 1])] += dp[i - 1][j]
            if (j + weights[i - 1] < 40001) {
                dp[i][j + weights[i - 1]] += dp[i - 1][j]
            }
        }
    }

    val answer = StringBuilder()

    for (marble in marbles) {
        var check = false
        for (i in 0..n) {
            if (dp[i][marble] >= 1) {
                answer.append("Y").append(" ")
                check = true
                break
            }
        }
        if (!check) {
            answer.append("N").append(" ")
        }
    }

    println(answer)
}
