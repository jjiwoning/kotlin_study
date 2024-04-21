package algo.programmers.P87946

import kotlin.math.max

class Solution {

    private lateinit var dungeons: Array<IntArray>
    private lateinit var visited: BooleanArray
    private var answer = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        this.dungeons = dungeons
        this.visited = BooleanArray(dungeons.size) { false }

        dfs(0, k)

        return answer
    }

    private fun dfs(depth: Int, hp: Int) {
        answer = max(answer, depth)

        for (i in dungeons.indices) {
            if (!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true
                dfs(depth + 1, hp - dungeons[i][1])
                visited[i] = false
            }
        }
    }
}
