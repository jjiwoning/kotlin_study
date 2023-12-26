package algo.boj

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

val list = mutableListOf<MutableList<Node>>()
val reverseList = mutableListOf<MutableList<Node>>()
lateinit var distance: IntArray
lateinit var visited: BooleanArray
var count = 0

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    distance = IntArray(n + 1) { 0 }
    visited = BooleanArray(n + 1) {false}

    for (i in 0..n) {
        list.add(mutableListOf())
        reverseList.add(mutableListOf())
    }

    for (i in 0 until m) {
        val st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        list[start].add(Node(end, cost))
        reverseList[end].add(Node(start, cost))
    }

    val st = StringTokenizer(readLine())
    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    dijkstra(start)
    findVisitedNode(end)

    println(distance[end])
    println(count)
}

fun dijkstra(start: Int) {
    val queue = PriorityQueue<Node>{o1, o2 -> o2.cost - o1.cost}
    queue.add(Node(start, 0))

    while (!queue.isEmpty()) {
        val node = queue.poll()

        for (next in list[node.position]) {
            if (distance[next.position] < next.cost + node.cost) {
                distance[next.position] = next.cost + node.cost
                queue.add(Node(next.position, distance[next.position]))
            }
        }
    }
}

fun findVisitedNode(end: Int) {
    val queue = LinkedList<Node>()
    queue.add(Node(end, distance[end]))

    while (!queue.isEmpty()) {
        val node = queue.poll()

        for (next in reverseList[node.position]) {
            if (node.cost - next.cost == distance[next.position]) {
                count++
                if (!visited[next.position]) {
                    visited[next.position] = true
                    queue.add(Node(next.position, distance[next.position]))
                }
            }
        }
    }
}

data class Node(
    val position: Int,
    val cost: Int
)
