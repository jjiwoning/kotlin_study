package algo.programmers.P120585

class Solution {
    fun solution(array: IntArray, height: Int): Int {
        return array.count { it > height };
    }
}