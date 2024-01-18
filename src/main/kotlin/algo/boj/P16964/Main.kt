package algo.boj.P16964

import java.util.*

val edges = mutableListOf<MutableList<Int>>()
lateinit var target: IntArray
var n = -1
var correct = false
var depth = 1
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    for (i in 0..n) {
        edges.add(mutableListOf())
    }

    for (i in 0 until n - 1) {
        val st = StringTokenizer(readLine())

        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        edges[start].add(end)
        edges[end].add(start)
    }

    val arr = IntArray(n + 1) { 0 }

    target = readLine().split(" ")
        .map { it.toInt() }
        .toIntArray()

    for (i in target.indices) {
        arr[target[i]] = i
    }

    for (edge in edges) {
        edge.sortBy { arr[it] }
    }

    if (target[0] != 1) {
        println(0)
        return
    }

    visited = BooleanArray(n + 1) { false }
    visited[1] = true
    dfs(1)

    if (correct) {
        println(1)
        return
    }
    println(0)
}

private fun dfs(
    now: Int
) {
    if (depth == n) {
        correct = true
        return
    }

    for (edge in edges[now]) {
        if (visited[edge]) {
            continue
        }
        if (edge != target[depth]) {
            return
        }
        visited[edge] = true
        depth++
        dfs(edge)
    }
}
