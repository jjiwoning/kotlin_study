package algo.programmers.P120909

import kotlin.math.sqrt

class Solution {
    fun solution(n: Int): Int {
        if (sqrt(n.toDouble()) == sqrt(n.toDouble()).toInt().toDouble()) {
            return 1
        }
        return 2
    }
}