package algo.programmers.P176963

class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val answer = IntArray(photo.size) { 0 }

        val score = hashMapOf<String, Int>()

        for (index in name.indices) {
            score[name[index]] = yearning[index]
        }

        for (index in photo.indices) {
            var nowScore = 0
            for (person in photo[index]) {
                nowScore += score.getOrDefault(person, 0)
            }
            answer[index] = nowScore
        }

        return answer
    }
}