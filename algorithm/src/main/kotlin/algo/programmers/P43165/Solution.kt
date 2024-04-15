package algo.programmers.P43165

class Solution {

    private lateinit var numbers: IntArray
    private var answer = 0;
    private var target = 0;

    fun solution(numbers: IntArray, target: Int): Int {
        this.numbers = numbers
        this.target = target

        dfs(0, 0)

        return answer
    }

    private fun dfs(now: Int, index: Int) {
        if (index == numbers.size) {
            if (now == target) {
                answer++
            }
            return
        }

        dfs(now + numbers[index], index + 1)
        dfs(now - numbers[index], index + 1)
    }
}
