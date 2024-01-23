package algo.programmers.P120818

class Solution {
    fun solution(price: Int): Int {
        if (price >= 500000) {
            return (price * 0.8).toInt()
        }
        if (price >= 300000) {
            return (price * 0.9).toInt()
        }
        if (price >= 100000) {
            return (price * 0.95).toInt()
        }
        return price
    }
}