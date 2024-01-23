package algo.programmers.P120819

const val COFFEE_AMOUNT = 5500

class Solution {
    fun solution(money: Int): IntArray {
        val answer: IntArray = intArrayOf(0, 0)
        answer[0] = money / COFFEE_AMOUNT
        answer[1] = money % COFFEE_AMOUNT
        return answer
    }
}