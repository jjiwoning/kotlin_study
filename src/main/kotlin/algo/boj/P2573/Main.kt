package algo.boj.P2573

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

var n = -1
var m = -1

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    val map = Array(n) { IntArray(m) { 0 } }

    for (i in 0 until n) {
        st = StringTokenizer(readLine())
        for (j in 0 until m) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    var answer = 0

    while (true) {
        val visited = Array(n) { BooleanArray(m) { false } }
        val melting = Array(n) { IntArray(m) { 0 } }
        var count = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    count++
                    bfs(visited, melting, map, Node(i, j))
                }
            }
        }

        if (count > 1) {
            println(answer)
            return
        }

        if (count == 0) {
            println(0)
            return
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                map[i][j] -= melting[i][j]
            }
        }

        answer++
    }
}

fun bfs(
    visited: Array<BooleanArray>,
    melting: Array<IntArray>,
    map: Array<IntArray>,
    start: Node
) {
    val queue: Queue<Node> = LinkedList()
    queue.add(start)
    visited[start.x][start.y] = true

    while (!queue.isEmpty()) {

        val now = queue.poll()

        for (i in 0 until 4) {
            val mx = now.x + dx[i]
            val my = now.y + dy[i]

            if (mx < 0 || mx >= n || my < 0 || my >= m) {
                continue
            }

            if (map[mx][my] <= 0) {
                melting[now.x][now.y]++
            }

            if (!visited[mx][my] && map[mx][my] > 0) {
                visited[mx][my] = true
                queue.add(Node(mx, my))
            }
        }

    }
}

data class Node(
    val x: Int,
    val y: Int
)
