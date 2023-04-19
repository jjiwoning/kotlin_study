package algo.programmers.P120583

class Solution {
    fun solution(array: IntArray, n: Int): Int {
        return array.count { it == n }
    }
}