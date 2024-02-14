package algo.boj.P14225

var n = -1
lateinit var numbers: List<Int>
lateinit var visited: BooleanArray
lateinit var results: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    numbers = readLine().split(" ").map { it.toInt() }

    visited = BooleanArray(n) { false }
    results = BooleanArray(numbers.sum() + 2) { false }

    combination(0, 0)

    for (i in 1 until results.size) {
        if (!results[i]) {
            println(i)
            return
        }
    }
}

private fun combination(
    result: Int,
    index: Int
) {
    results[result] = true

    for (i in index until n) {
        if (visited[i]) {
            continue
        }
        visited[i] = true
        combination(result + numbers[i], i + 1)
        visited[i] = false
    }

}
