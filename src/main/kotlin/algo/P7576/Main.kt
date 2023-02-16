package algo.P7576

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

data class Tomato(var x: Int, var y: Int)

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

val queue: Queue<Tomato> = LinkedList()

fun main(args: Array<String>) {

    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var box = Array(size = m) { IntArray(size = n) { 0 } }

    for (i in box.indices) {
        val s = br.readLine().split(" ")
        for (j in box[0].indices) {
            val num = s[j].toInt()
            box[i][j] = num
            if (num == 1) {
                queue.add(Tomato(i, j))
            }
        }
    }

    bfs(n, m, box)

    var answer = Int.MIN_VALUE;
    var check = false

    for (i in box.indices) {
        for (j in box[0].indices) {
            if (box[i][j] == 0) {
                check = true
                answer = 0
                break
            }
            answer = max(answer, box[i][j])
        }
        if (check) {
            break
        }
    }

    println(answer - 1)
}

fun bfs(n: Int, m: Int, box: Array<IntArray>) {
    while (!queue.isEmpty()) {
        val tomato = queue.poll()
        for (i in dx.indices) {
            val dx = tomato.x + dx[i]
            val dy = tomato.y + dy[i]
            if (dx < 0 || dx >= m || dy < 0 || dy >= n || box[dx][dy] == -1) {
                continue
            }
            if (box[dx][dy] == 0) {
                box[dx][dy] = box[tomato.x][tomato.y] + 1
                queue.add(Tomato(dx, dy))
            }
        }
    }
}