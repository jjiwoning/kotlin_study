package algo.programmers.P42578

class Solution {

    private val clothes: MutableMap<String, Int> = mutableMapOf()

    fun solution(clothes: Array<Array<String>>): Int {
        for (clothe in clothes) {
            this.clothes[clothe[1]] = this.clothes.getOrDefault(clothe[1], 0) + 1
        }

        var answer = 1

        for (key in this.clothes.keys) {
            answer *= this.clothes[key]!! + 1
        }

        return answer - 1
    }
}
