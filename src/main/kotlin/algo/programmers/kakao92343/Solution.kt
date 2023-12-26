package algo.programmers.kakao92343

import kotlin.math.max

class Solution {

    val edges = mutableListOf<MutableList<Int>>()
    var answer = 0
    lateinit var info: IntArray

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        this.info = info
        for (i in info.indices) {
            this.edges.add(mutableListOf())
        }

        for (edge in edges) {
            this.edges[edge[0]].add(edge[1]) // 간선에 넣어주기
        }

        dfs(0, 0, 0, mutableListOf())

        return answer
    }

    private fun dfs(start: Int, sheepCount: Int, wolfCount: Int, nextNodes: MutableList<Int>) {
        var newSheepCount = sheepCount
        var newWolfCount = wolfCount
        if (info[start] == 0) { // sheep
            newSheepCount++
        }
        if (info[start] == 1) { // wolf
            newWolfCount++
        }

        if (newSheepCount <= newWolfCount) { // 늑대가 양을 잡아먹는 타이밍
            return
        }

        answer = max(answer, newSheepCount)

        val nodes = mutableListOf<Int>()
        nodes.addAll(edges[start])
        nodes.addAll(nextNodes)

        val size = nodes.size

        for (i in 0 until size) {
            val next = nodes[0]
            nodes.remove(next)
            dfs(next, newSheepCount, newWolfCount, nodes)
            nodes.add(next)
        }
    }
}

fun main() {
    val sol = Solution()
    sol.solution(intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1),
        arrayOf(intArrayOf(0, 1),
            intArrayOf(1,2),
            intArrayOf(1,4),
            intArrayOf(0,8),
            intArrayOf(8,7),
            intArrayOf(9,10),
            intArrayOf(9,11),
            intArrayOf(4,3),
            intArrayOf(6,5),
            intArrayOf(4,6),
            intArrayOf(8,9))
    )

}
