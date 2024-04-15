package algo.programmers.P43162

class Solution {

    private lateinit var computers: Array<IntArray>
    private lateinit var visited: BooleanArray

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        visited = BooleanArray(n) { false }
        this.computers = computers

        repeat(n) {
            if (!visited[it]) {
                answer++
                visited[it] = true
                dfs(it)
            }
        }

        return answer
    }

    private fun dfs(node: Int) {
        for (i in 0 until computers[node].size) {
            if (computers[node][i] == 1) {
                if (!visited[i]) {
                    visited[i] = true
                    dfs(i)
                }
            }
        }
    }
}
