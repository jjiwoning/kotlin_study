package algo.programmers.P120831

class Solution {
    fun solution(n: Int): Int {
        if (n % 2 == 1) {
            return (n / 2 + 1) * (2 + (n / 2) * 2) / 2
        }
        return (n / 2) * (2 + (n / 2) * 2) / 2
    }
}