package algo.boj.P1823

import kotlin.math.max

var n = 0

lateinit var arr: IntArray
lateinit var dp: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = IntArray(n) { 0 }
    dp = Array(n + 1) { IntArray(n + 1) { 0 } }

    for (i in 0 until n) {
        arr[i] = readLine().toInt()
    }

    println(dfs(0, 0, n - 1))
}

private fun dfs(depth: Int, left: Int, right: Int): Int {
    if (depth == n) {
        return 0
    }
    if (dp[left][right] != 0) {
        return dp[left][right]
    }

    val leftStart = dfs(depth + 1, left + 1, right) + (depth + 1) * arr[left]
    val rightStart = dfs(depth + 1, left, right - 1) + (depth + 1) * arr[right]

    dp[left][right] = max(leftStart, rightStart)

    return dp[left][right]
}
