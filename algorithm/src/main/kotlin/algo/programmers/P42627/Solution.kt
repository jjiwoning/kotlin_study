package algo.programmers.P42627

import java.util.*
import kotlin.math.floor

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var index = 0
        var endTime = 0
        var count = 0

        Arrays.sort(jobs) { o1: IntArray, o2: IntArray -> o1[0] - o2[0] }

        val priorityQueue = PriorityQueue { o1: IntArray, o2: IntArray -> o1[1] - o2[1] }

        while (count < jobs.size) {
            while (index < jobs.size && jobs[index][0] <= endTime) {
                priorityQueue.add(jobs[index])
                index++
            }

            if (priorityQueue.isEmpty()) {
                endTime = jobs[index][0]
            } else {
                val temp = priorityQueue.poll()
                answer += temp[1] - temp[0] + endTime
                endTime += temp[1]
                count++
            }
        }

        return floor((answer / jobs.size).toDouble()).toInt()
    }
}
