package algo.programmers.P169199

import java.util.PriorityQueue

class Solution {

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    lateinit var target: Node
    lateinit var start: Node
    lateinit var visited: Array<Array<Boolean>>
    lateinit var board: Array<String>

    fun solution(board: Array<String>): Int {
        this.board = board
        visited = Array(board.size) { Array(board[0].length) {false} }

        for (i in board.indices) {
            for (j in board[i].indices) {
                val c = board[i][j]
                if (c == 'G') {
                    target = Node(i, j, 0)
                }
                if (c == 'R') {
                    start = Node(i, j, 0)
                }
            }
        }

        var check = false

        for (i in 0 until 4) {
            val mx = target.x + dx[i]
            val my = target.y + dy[i]

            if (mx < 0 || mx >= board.size || my < 0 || my >= board[0].length) {
                check = true
                break
            }

            if (board[mx][my] == 'D') {
                check = true
                break
            }
        }

        if (!check) {
            return -1
        }

        return bfs(start)
    }

    fun bfs(start: Node): Int {
        val priorityQueue = PriorityQueue<Node> { o1, o2 -> o1.moveCount - o2.moveCount }
        priorityQueue.add(start)
        visited[start.x][start.y] = true

        while (!priorityQueue.isEmpty()) {
            val now = priorityQueue.poll()

            for (i in 0 until 4) {
                var mx = now.x
                var my = now.y
                while (true) {
                    mx += dx[i]
                    my += dy[i]

                    if (isOutOfRange(mx, my) || isBlocking(mx, my)) {
                        if (visited[mx - dx[i]][my - dy[i]]) {
                            break
                        }
                        if (board[mx - dx[i]][my - dy[i]] == 'G') {
                            return now.moveCount + 1
                        }
                        visited[mx - dx[i]][my - dy[i]] = true
                        priorityQueue.add(Node(mx - dx[i], my - dy[i], now.moveCount + 1))
                        break
                    }
                }
            }
        }

        return -1;
    }

    private fun isOutOfRange(mx: Int, my: Int) =
        mx < 0 || mx >= board.size || my < 0 || my >= board[0].length

    private fun isBlocking(mx: Int, my: Int) = board[mx][my] == 'D'
}

data class Node(
    val x: Int,
    val y: Int,
    val moveCount: Int
)
