package algo.boj.P10159

import java.util.StringTokenizer
import kotlin.math.min

const val MAX = 987654321

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    val graph = Array(n + 1) { IntArray(n + 1) { MAX } }

    for (i in 1..n) {
        graph[i][i] = 0
    }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        graph[start][end] = 0
    }

    for (mid in 1..n) {
        for (start in 1..n) {
            for (end in 1..n) {
                graph[start][end] = min(graph[start][end], graph[start][mid] + graph[mid][end])
            }
        }
    }

    val answer = StringBuilder()

    for (i in 1..n) {
        var count = 0
        for (j in 1..n) {
            if (i == j) {
                continue
            }
            if (graph[i][j] == MAX && graph[j][i] == MAX) {
                count++
            }
        }
        answer.append(count).append("\n")
    }

    println(answer)
}
