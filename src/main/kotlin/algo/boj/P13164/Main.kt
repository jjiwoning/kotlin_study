package algo.boj.P13164

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val arr = readLine().split(" ")
        .map { s -> s.toInt() }
        .toIntArray()

    val priorityQueue = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    var answer = 0;

    for (i in 0 until arr.size - 1) {
        priorityQueue.add(arr[i + 1] - arr[i])
        answer += arr[i + 1] - arr[i]
    }

    for (i in 0 until k - 1) {
        answer -= priorityQueue.poll() // 양 옆 차이가 가장 큰 친구 팀에서 분리하기
    }

    println(answer)
}
