package algo.boj.P13023

import java.util.StringTokenizer

private val edges = mutableListOf<MutableList<Int>>()
private lateinit var visited: Array<Boolean>
private var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    repeat(n) {
        edges.add(mutableListOf())
    }

    repeat(m) {
        st = StringTokenizer(readLine())

        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        edges[x].add(y)
        edges[y].add(x)
    }

    visited = Array(n) { false }

    repeat(n) {
        visited = Array(n) { false }
        if (answer == 1) {
            println(answer)
            return
        }
        visited[it] = true
        dfs(it, 0)
    }

    println(answer)
}

private fun dfs(now: Int, depth: Int) {
    if (depth == 4) {
        answer = 1
        return
    }

    for (next in edges[now]) {
        if (!visited[next]) {
            visited[next] = true
            dfs(next, depth + 1)
            visited[next] = false
        }
    }
}
