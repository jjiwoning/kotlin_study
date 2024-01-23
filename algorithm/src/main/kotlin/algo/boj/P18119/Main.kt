package algo.boj.P18119

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    var alpha = (1 shl 27) - 1
    val words = IntArray(n) {0}

    for (i in 0 until n) {
        val word = readLine().toCharArray()

        for (c in word) {
            words[i] = words[i] or (1 shl (c - 'a'))
        }
    }

    val answer = StringBuilder()

    for (i in 0 until m) {
        st = StringTokenizer(readLine())
        val o = st.nextToken().toInt()
        val x = st.nextToken()[0] - 'a'

        if (o == 1) {
            alpha = alpha and (1 shl x).inv()
        }

        if (o == 2) {
            alpha = alpha or (1 shl x)
        }

        var count = 0

        for (word in words) {
            if (alpha and word >= word) {
                count++
            }
        }

        answer.append(count).append("\n")
    }

    println(answer)
}
