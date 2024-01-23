package algo.boj.P1085

import java.util.StringTokenizer
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())

    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val h = st.nextToken().toInt()

    var answer : Int = min(x, y)
    answer = min(answer, w - x)
    answer = min(answer, h - y)

    println(answer)
}