package algo.programmers.P120849

class Solution {
    fun solution(my_string: String): String {
        return my_string.replace("a", "")
            .replace("e", "")
            .replace("i", "")
            .replace("o", "")
            .replace("u", "")
    }
}