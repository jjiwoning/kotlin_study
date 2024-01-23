package algo.programmers.P12939

class Solution {
    fun solution(s: String): String {
        val numbers = s.split(" ")

        val min = numbers.map { number -> number.toInt() }
            .minOf { number -> number }

        val max = numbers.map { number -> number.toInt() }
            .maxOf { number -> number }

        return "$min $max"
    }
}