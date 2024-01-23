package algo.programmers.P120814

class Solution {
    fun solution(n: Int): Int {
        if (n % 7 == 0) {
            return n / 7
        }
        return n / 7 + 1
    }
}