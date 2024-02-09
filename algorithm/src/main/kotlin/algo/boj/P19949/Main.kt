package algo.boj.P19949

lateinit var arr: IntArray
val makeArr = IntArray(10) { 0 }

var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    arr = readLine().split(" ")
        .map { it.toInt() }
        .toIntArray()

    dfs(0)

    println(answer)
}

private fun dfs(depth: Int) {
    if (depth == 10) {
        if (checkAnswer()) {
            answer++
        }
        return
    }

    for (i in 1..5) {
        if (depth >= 2 && i == makeArr[depth - 1] && i == makeArr[depth - 2]) {
            continue
        }
        makeArr[depth] = i
        dfs(depth + 1)
        makeArr[depth] = 0
    }
}

private fun checkAnswer(): Boolean {
    var count = 0

    for (i in 0 until 10) {
        if (arr[i] == makeArr[i]) {
            count++
        }

        if (count == 5) {
            return true
        }
    }

    return false
}
