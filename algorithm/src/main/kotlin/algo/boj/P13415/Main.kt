package algo.boj.P13415

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val list = Array(n) {Node(-1)}
    val result = Array(n) {Node(-1)}

    var st = StringTokenizer(readLine())

    for (i in 0 until n) {
        val value = st.nextToken().toInt()
        list[i] = Node(value)
        result[i] = Node(value)
    }

    val k = readLine().toInt()

    val queue = ArrayDeque<Int>()

    for (i in 0 until k) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        while (!queue.isEmpty() && abs(queue.peekLast()) <= a) {
            queue.pollLast()
        }
        queue.addLast(a)
        while (!queue.isEmpty() && abs(queue.peekLast()) <= b) {
            queue.pollLast()
        }
        queue.addLast(b * -1)
    }

    val maxIndex = abs(queue.peekFirst())

    Arrays.sort(list, 0, maxIndex) {o1, o2 -> o1.value - o2.value}

    var ascendIdx = maxIndex - 1
    var descendIdx = 0
    var sortedArrIdx = maxIndex - 1

    while (!queue.isEmpty()) {
        val idx = queue.pollFirst()

        var startIndex = 0

        if (!queue.isEmpty()) {
            startIndex = abs(queue.peekFirst())
        }

        val length = abs(idx) - startIndex

        if (idx > 0) {
            for (j in 0 until length) {
                result[sortedArrIdx--] = list[ascendIdx--]
            }
        }

        if (idx < 0) {
            for (j in 0 until length) {
                result[sortedArrIdx--] = list[descendIdx++]
            }
        }


    }

    val answer = StringBuilder()
    for (node in result) {
        answer.append(node.value).append(" ")
    }
    println(answer)
}

data class Node(
    val value: Int
)
