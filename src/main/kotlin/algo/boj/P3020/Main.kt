package algo.boj.P3020

import java.util.StringTokenizer
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())

    val n = st.nextToken().toInt() // 개수
    val h = st.nextToken().toInt() // 높이

    val arr1 = IntArray(h + 2) { 0 } // 석순 누적합 배열
    val arr2 = IntArray(h + 2) { 0 } // 종유석 누적합 배열

    for (i in 1..n) {
        val height = readLine().toInt()

        if (i % 2 == 1) {
            arr1[0]++
            arr1[height + 1]--
        }

        if (i % 2 == 0) {
            arr2[h + 1]++
            arr2[h - height]--
        }
    }

    for (i in 1..h) {
        arr1[i] += arr1[i - 1]
    }

    for (i in h + 1 downTo 1) {
        arr2[i - 1] += arr2[i]
    }

    val result = IntArray(h + 2) { 0 } // 누적합 합칠 배열

    for (i in 0 until h + 1) {
        result[i] = arr1[i] + arr2[i]
    }

    var minValue = Int.MAX_VALUE

    for (i in 1..h) {
        minValue = min(minValue, result[i])
    }

    var cnt = 0
    for (i in 1..h) {
        if (result[i] == minValue) {
            cnt++
        }
    }

    println("${minValue} ${cnt}")
}
