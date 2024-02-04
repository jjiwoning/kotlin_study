package algo.boj.P2878

import java.util.*
import kotlin.math.min
import kotlin.math.pow

private val MOD_CONST = 2.0.pow(64.0).toLong()

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())

    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val candies = mutableListOf<Int>()
    var wantedCandiesCount = 0L

    repeat(n) {
        val count = readLine().toInt()
        candies.add(count)
        wantedCandiesCount += count
    }

    candies.sort()

    var answer: Long = 0
    var remainCandiesCount = wantedCandiesCount - m

    for ((index, candy) in candies.withIndex()) {
        val count = min(candy * 1L, remainCandiesCount / (n - index))

        remainCandiesCount -= count

        answer += count * count
        answer %= MOD_CONST
    }

    println(answer)
}
