package algo.programmers.P120847

class Solution {
    fun solution(numbers: IntArray): Int {
        numbers.sortDescending()
        return numbers[0] * numbers[1]
    }
}