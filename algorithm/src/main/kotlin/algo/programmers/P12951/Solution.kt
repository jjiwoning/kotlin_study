package algo.programmers.P12951

class Solution {
    fun solution(s: String): String {
        val lowercase = s.lowercase()

        var space = true

        val answer = StringBuilder()

        for (c in lowercase) {
            if (space) {
                answer.append(c.uppercase())
            }
            if (!space) {
                answer.append(c)
            }
            if (c != ' ') {
                space = false
                continue
            }
            if (c == ' ') {
                space = true
                continue
            }
        }

        return answer.toString()
    }
}
