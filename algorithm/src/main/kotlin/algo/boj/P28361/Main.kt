package algo.boj.P28361

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val answer = StringBuilder()

    answer.append(1).append(" ")

    if (n % 3 == 0) {
        val ls = mutableListOf<Int>()
        ls.add(3)

        for (i in 2..n + 2 step 3) {
            for (j in 0..4 step 2) {
                ls.add(i + j)
            }
        }

        for (i in 0 until n - 1) {
            answer.append(ls[i]).append(" ")
        }
    }

    if (n % 3 != 0) {
        val ls = mutableListOf<Int>()
        ls.add(2)
        ls.add(4)

        for (i in 3..n + 2 step 3) {
            for (j in 0..4 step 2) {
                ls.add(i + j)
            }
        }

        for (i in 0 until n - 1) {
            answer.append(ls[i]).append(" ")
        }
    }

    answer.append(1).append(" ")

    println(n)
    println(answer)
}
