package algo.programmers.P43163

import kotlin.math.min

class Solution {

    private var answer = Int.MAX_VALUE
    private lateinit var target: String
    private lateinit var words: Array<String>
    private lateinit var visited: BooleanArray

    fun solution(begin: String, target: String, words: Array<String>): Int {

        this.target = target
        this.words = words
        this.visited = BooleanArray(words.size) { false }


        dfs(0, begin)

        return if (answer == Int.MAX_VALUE) {
            0
        } else {
            answer
        }
    }

    private fun dfs(depth: Int, value: String) {
        if (value == this.target) {
            answer = min(answer, depth)
            return
        }

        for ((index, word) in words.withIndex()) {
            if (!visited[index] && checkWord(value, word)) {
                visited[index] = true
                dfs(depth + 1, word)
                visited[index] = false
            }
        }
    }

    private fun checkWord(word: String, other: String): Boolean {
        if (word.length != other.length) {
            return false
        }

        var count = 0

        for (index in word.indices) {
            if (word[index] != other[index]) {
                count++
            }
        }

        return count < 2
    }
}
