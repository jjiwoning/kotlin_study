package algo.boj.P5557

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ")
        .map { it.toInt() }
        .toIntArray()

    val dp = Array(n + 1) { LongArray(21) { 0L } }

    dp[1][arr[0]] = 1

    for (i in 1 until arr.size - 1) {
        for (j in 0..20) {
            if (arr[i] + j <= 20) {
                dp[i + 1][arr[i] + j] += dp[i][j]
            }
            if (j - arr[i] >= 0) {
                dp[i + 1][j - arr[i]] += dp[i][j]
            }
        }
    }

    val answer = dp[n - 1][arr[arr.size - 1]]

    println(answer)
}
