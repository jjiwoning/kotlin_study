package algo.programmers.P120825

class Solution {
    fun solution(my_string: String, n: Int): String {
        return my_string.map { it.toString().repeat(n) }.joinToString().replace(", ", "")
    }
}