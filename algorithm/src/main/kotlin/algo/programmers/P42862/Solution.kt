package algo.programmers.P42862

class Solution {

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

        var answer = n

        val losts = lost.map { Cloth(it) }.toHashSet()
        val reserves = reserve.map { Cloth(it) }.toHashSet()

        val removes = HashSet<Cloth>()

        for (cloth in losts) {
            if (reserves.contains(cloth)) {
                removes.add(cloth)
            }
        }

        reserves.removeAll(removes)
        losts.removeAll(removes)

        for (cloth in losts) {
            if (reserves.contains(Cloth(cloth.id - 1))) {
                reserves.remove(Cloth(cloth.id - 1))
                continue
            }
            if (reserves.contains(Cloth(cloth.id + 1))) {
                reserves.remove(Cloth(cloth.id + 1))
                continue
            }
            answer--
        }

        return answer
    }
}

data class Cloth(
    val id: Int
)
