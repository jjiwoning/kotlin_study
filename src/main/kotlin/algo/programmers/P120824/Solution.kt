package algo.programmers.P120824

class Solution {
    fun solution(num_list: IntArray): IntArray {
        val answer: IntArray = intArrayOf(0, 0)
        val oddCount = num_list.map { it }.count { it % 2 == 1 }
        answer[1] = oddCount
        answer[0] = num_list.count() - answer[1]
        return answer
    }
}