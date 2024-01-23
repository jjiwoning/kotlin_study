package algo.programmers.kakao64063

fun main() {
    val sol = Solution()
    sol.solution(10, longArrayOf(1L, 3L, 4L, 1L, 3L, 1L))
}

class Solution {

    val parent = mutableMapOf<Long, Long>()

    fun solution(k: Long, room_number: LongArray): LongArray {
        val answer = mutableListOf<Long>()

        for (room in room_number) {
            val find = find(room)
            answer.add(find)
            union(find, find + 1)
        }

        return answer.toLongArray()
    }

    fun union(x: Long, y: Long) {
        val x1 = find(x)
        val y1 = find(y)
        if (x1 > y1) {
            parent[y1] = x1
        }
        if (x1 < y1) {
            parent[x1] = y1
        }
    }

    fun find(x: Long): Long {
        if (!parent.containsKey(x) || parent[x] == x) {
            parent[x] = x
            return x
        }
        parent[x] = find(parent[x]!!)
        return parent[x]!!
    }
}
