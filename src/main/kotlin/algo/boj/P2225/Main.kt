package algo.boj.P2225

import java.util.StringTokenizer

const val MOD_NUMBER = 1_000_000_000

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    // 0부터 N 까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
    // dp[개수][값]
    val dp = Array(k + 1) { IntArray(n + 1) { 0 } }

    for (i in 0..n) {
        dp[1][i] = 1 // 정수 1개를 더해서 그 합이 되는 수는 자기 자신
    }

    for (i in 0..k) {
        dp[i][0] = 1 // 0이 되는 경우 -> 아무것도 없는 경우의 수 1
    }

    for (i in 2..k) {
        for (j in 1..n) {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
            dp[i][j] %= MOD_NUMBER
        }
    }

    println(dp[k][n] % MOD_NUMBER)
}
