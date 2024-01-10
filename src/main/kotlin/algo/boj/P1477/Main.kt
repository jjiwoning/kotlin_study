package algo.boj.P1477

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt() // 휴게소 개수
    val m = st.nextToken().toInt() // 더 지으려고하는 휴게소의 수
    val l = st.nextToken().toInt() // 고속도로의 길이

    val restAreas = mutableListOf<Int>()
    restAreas.add(l)

    st = StringTokenizer(readLine())

    for (i in 0 until n) {
        restAreas.add(st.nextToken().toInt())
    }

    restAreas.sort()

    println(binarySearch(m, restAreas))
}

fun binarySearch(
    count: Int,
    restAreas: MutableList<Int>
): Int {

    var start = 1 // 휴게소가 한 칸은 떨어져있어야한다.
    var end = restAreas[restAreas.size - 1] + 1

    while (start < end) {
        val mid = (start + end) / 2

        if (canMakeRestArea(restAreas, mid, count)) {
            // mid가 최대일 때 휴게소를 지을 수 있다면
            // mid를 더 줄여서 다음 탐색 진행하기
            end = mid
            continue
        }
        // 지을 수 없는 상황이면
        // mid를 더 크게 만들어 다음 탐색 진행하기
        start = mid + 1
    }

    return end
}

fun canMakeRestArea(
    restAreas: MutableList<Int>,
    targetDistance: Int,
    count: Int
): Boolean {
    var nowCount = 0
    var nowPosition = 0

    for (restArea in restAreas) {
        if (nowPosition + targetDistance < restArea) {
            // 현재 거리로는 도달할 수 없는 상태
            nowCount += (restArea - nowPosition) / targetDistance
            if ((restArea - nowPosition) % targetDistance == 0) {
                // 나누어 떨어지는 경우 1개가 더 들어가게 됨 -> 빼줘야됨
                nowCount--
            }
        }
        nowPosition = restArea
    }

    return nowCount <= count // 설치된 휴게소가 원하는 휴게소 개수보다 작다면 휴게소 설치 가능
}
