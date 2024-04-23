package algo.programmers.P42747

class Solution {

    fun solution(citations: IntArray): Int {
        citations.sortDescending()

        for (i in citations.indices) {
            if (citations[i] < i + 1) {
                return i
            }
        }

        return citations.size
    }
}
