package algo.boj.P11509

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val balloons = readLine().split(" ")
        .map { it.toInt() }
        .toIntArray()

    val arrows = mutableMapOf<Int, Int>()
    var answer = 0

    for (balloon in balloons) {
        if (arrows.getOrDefault(balloon, 0) == 0) {
            answer++
            arrows[balloon - 1] = arrows.getOrDefault(balloon - 1, 0) + 1
        } else {
            arrows[balloon] = arrows.getOrDefault(balloon, 0) - 1
            arrows[balloon - 1] = arrows.getOrDefault(balloon - 1, 0) + 1
        }
    }

    println(answer)
}
