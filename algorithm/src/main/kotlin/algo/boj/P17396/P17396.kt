package algo.boj.P17396

import java.util.PriorityQueue
import java.util.StringTokenizer

private const val MAX_VALUE = 100000000001

private val edges: MutableList<MutableList<Node>> = mutableListOf()
private lateinit var distance: LongArray

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt() // 분기점
    val m = st.nextToken().toInt() // 간선의 수

    val nodes = readLine().split(" ")
        .map { s -> s.toInt() }
        .toIntArray()

    nodes[n - 1] = 0

    distance = LongArray(n) { MAX_VALUE }

    for (i in 0 until n) {
        edges.add(mutableListOf())
    }

    for (i in 0 until m) {
        st = StringTokenizer(readLine())
        val n1 = st.nextToken().toInt()
        val n2 = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        if (nodes[n1] == 1 || nodes[n2] == 1) { // 아예 간선 추가 안하기
            continue
        }

        edges[n1].add(Node(n2, cost + 0L))
        edges[n2].add(Node(n1, cost + 0L))
    }

    dijkstra(0)

    if (distance[n - 1] >= MAX_VALUE) {
        println(-1)
        return
    }

    println(distance[n - 1])
}

private fun dijkstra(start: Int) {
    val priorityQueue = PriorityQueue<Node> { o1, o2 -> o1.cost.compareTo(o2.cost) }
    priorityQueue.add(Node(start, 0))
    distance[start] = 0

    while (!priorityQueue.isEmpty()) {
        val now = priorityQueue.poll()

        if (distance[now.edge] < now.cost) {
            continue
        }

        for (next in edges[now.edge]) {
            if (now.cost + next.cost < distance[next.edge]) {
                distance[next.edge] = now.cost + next.cost
                priorityQueue.add(Node(next.edge, distance[next.edge]))
            }
        }
    }
}

data class Node(
    val edge: Int,
    val cost: Long
)
