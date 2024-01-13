package algo.boj.P2304

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val pillars = mutableListOf<Pillar>()

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        pillars.add(Pillar(x, y))
    }

    pillars.sortWith { o1, o2 -> o1.x - o2.x }

    val findMaxHeight = pillars.maxOfOrNull { pillar -> pillar.y }

    val maxHeightPillars = pillars.filter { pillar -> pillar.y == findMaxHeight }
        .toMutableList()

    maxHeightPillars.sortWith { o1, o2 -> o1.x - o2.x }

    var answer = 0

    answer += findMaxHeight!! * (maxHeightPillars[maxHeightPillars.size - 1].x - maxHeightPillars[0].x + 1)

    var nowX = -1
    var nowHeight = -1

    for (pillar in pillars) {

        if (pillar.y == findMaxHeight) {
            if (nowX == -1) {
                break
            }
            answer += nowHeight * (pillar.x - nowX)
            break
        }

        if (nowX == -1 && nowHeight == -1) {
            nowX = pillar.x
            nowHeight = pillar.y
            continue
        }

        if (nowHeight > pillar.y) {
            continue
        }

        if (nowHeight < pillar.y) {
            answer += nowHeight * (pillar.x - nowX)
            nowX = pillar.x
            nowHeight = pillar.y
            continue
        }
    }

    nowX = -1
    nowHeight = -1

    for (i in pillars.size - 1 downTo 0) {
        if (pillars[i].y == findMaxHeight) {
            if (nowX == -1) {
                break
            }
            answer += nowHeight * abs(pillars[i].x - nowX)
            break
        }

        if (nowX == -1 && nowHeight == -1) {
            nowX = pillars[i].x
            nowHeight = pillars[i].y
            continue
        }

        if (nowHeight > pillars[i].y) {
            continue
        }

        if (nowHeight < pillars[i].y) {
            answer += nowHeight * abs(pillars[i].x - nowX)
            nowX = pillars[i].x
            nowHeight = pillars[i].y
            continue
        }
    }

    println(answer)
}

data class Pillar(
    val x: Int,
    val y: Int
)
