package algo.boj.P1039

import java.util.*
import kotlin.math.max

var answer = -1
var k = 0
val visited = mutableMapOf<Int, MutableSet<Int>>()

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())

    val target = st.nextToken().toCharArray()
    k = st.nextToken().toInt()

    dfs(0, target)

    println(answer)
}

fun dfs(
    depth: Int,
    now: CharArray
) {
    if (now[0] == '0') {
        // 불가능
        return
    }

    val number = String(now).toInt()

    if (depth == k) {
        answer = max(answer, number)
        return
    }

    if (visited.containsKey(number)) {
        if (visited[number]!!.contains(depth)) {
            return
        }
    }
    if (!visited.containsKey(number)) {
        visited[number] = mutableSetOf()
    }
    visited[number]!!.add(depth)

    for (i in 0 until now.size - 1) {
        for (j in i + 1 until now.size) {
            if (now[i] == now[j]) {
                answer = max(answer, number)
                continue
            }
            val swapChar = swapChar(now, i, j)
            dfs(depth + 1, swapChar)
        }
    }
}

fun swapChar(
    now: CharArray,
    idx1: Int,
    idx2: Int
): CharArray {
    val newCharArray = now.clone()
    val keep = newCharArray[idx1]
    newCharArray[idx1] = newCharArray[idx2]
    newCharArray[idx2] = keep

    return newCharArray
}
