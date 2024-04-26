package algo.programmers.P70129

class Solution {
    fun solution(s: String): IntArray {
        var s = s
        val answer = IntArray(2)

        while (s != "1") {
            val s1 = s.replace("0".toRegex(), "")
            answer[1] += s.length - s1.length
            answer[0]++
            s = Integer.toBinaryString(s1.length).toString()
        }
        return answer
    }
}
