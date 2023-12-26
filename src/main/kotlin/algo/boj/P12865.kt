package algo.boj

import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val dp = Array(n + 1) {IntArray(k + 1) { 0 } }

    for (i in 1..n) {
        st = StringTokenizer(readLine())
        val w = st.nextToken().toInt() // 무게
        val v = st.nextToken().toInt() // 가치

        for (weight in 1 until min(w, k)) {
            dp[i][weight] = dp[i - 1][weight]
        }

        for (weight in w..k) {
            dp[i][weight] = max(dp[i - 1][weight - w] + v, dp[i][weight - 1]) // 조건 1 -> 가방에 추가 vs 이전 무게의 값
            dp[i][weight] = max(dp[i][weight], dp[i - 1][weight]) // 조건 2 -> 현재 가치 vs 이전 가치
        }
    }

    var answer = 0
    for (i in 0..k) {
        answer = max(answer, dp[n][i])
    }
    println(answer)
}
