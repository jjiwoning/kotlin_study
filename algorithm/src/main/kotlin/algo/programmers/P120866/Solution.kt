package algo.programmers.P120866

class Solution {

    private val dx = intArrayOf(0, 0, 1, -1, -1, 1, 1, -1)
    private val dy = intArrayOf(1, -1, 0, 0, 1, -1, 1, -1)

    fun solution(board: Array<IntArray>): Int {
        var answer = 0

        val n = board.size

        for (i in board.indices) {
            for (j in board.indices) {
                if (board[i][j] == 1) {
                    for (k in 0 until 8) {
                        val mx = i + dx[k]
                        val my = j + dy[k]

                        if (mx < 0 || mx >= n || my < 0 || my >= n) {
                            continue
                        }

                        if (board[mx][my] == 1) {
                            continue
                        }

                        board[mx][my] = -1
                    }
                }
            }
        }

        for (ints in board) {
            for (int in ints) {
                if (int == 0) {
                    answer++
                }
            }
        }

        return answer
    }
}
