package algo.programmers.P42842

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val totalCount = brown + yellow

        var height = 1
        var width = totalCount / height

        while (true) {
            if (width.toDouble() != totalCount.toDouble() / height) {
                height++
                width = totalCount / height
            }

            val yellowCount = (height - 2) * (width - 2)

            if (yellowCount == yellow) {
                return intArrayOf(width, height)
            }

            height++
            width = totalCount / height
        }
    }
}
