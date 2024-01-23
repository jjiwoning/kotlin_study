package algo.boj.P1943

import java.util.*
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val answer = StringBuilder()

    for (i in 0 until 3) {
        val n = readLine().toInt()
        var value = 0
        val dp = IntArray(100001) { 0 }
        dp[0] = 1

        val moneys = mutableListOf<Info>()

        for (j in 0 until n) {
            val st = StringTokenizer(readLine())
            val money = st.nextToken().toInt()
            val count = st.nextToken().toInt()

            moneys.add(Info(money, count))
            value += money * count
        }

        if (value % 2 == 1) {
            answer.append(0).append("\n")
            continue
        }

        for (j in 0 until n) {
            val now = moneys[j]
            val count = now.count
            val money = now.money

            if (dp[value / 2] != 0) {
                break
            }

            for (k in min(50000, value) downTo 0) {
                if (dp[k] != 0) {
                    continue
                }
                if (dp[value / 2] != 0) {
                    break
                }
                for (l in 1..count) {
                    if (k - money * l < 0) {
                        continue
                    }
                    if (dp[k - money * l] > 0) {
                        dp[k] += dp[k - money * l]
                        break
                    }
                }
            }
        }

        if (dp[value / 2] == 0) {
            answer.append(0).append("\n")
            continue
        }
        answer.append(1).append("\n")
    }

    println(answer)
}

data class Info(
    val money: Int,
    val count: Int
)
