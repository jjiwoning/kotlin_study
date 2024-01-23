package algo.boj.P2503

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val games = mutableListOf<Game>()
    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        games.add(Game(st.nextToken(), st.nextToken().toInt(), st.nextToken().toInt()))
    }

    var answer = 0

    for (i in 123..987) {
        if (!checkNum(i)) {
            continue
        }

        answer++

        for (game in games) {
            if (!game.checkGameResult(i.toString())) {
                answer--
                break
            }
        }
    }

    println(answer)
}

private fun checkNum(num: Int): Boolean {
    val str = num.toString()
    if (str[0] == '0' || str[1] == '0' || str[2] == '0') {
        return false
    }
    if (str[0] == str[1] || str[1] == str[2] || str[0] == str[2]) {
        return false
    }
    return true
}

data class Game(
    val value: String,
    val strike: Int,
    val ball: Int
) {
    fun checkGameResult(num: String): Boolean {
        var strikeCount = 0
        var ballCount = 0

        for (i in 0..2) {
            if (value[i] == num[i]) {
                strikeCount++
            }
        }

        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    continue
                }
                if (value[i] == num[j]) {
                    ballCount++
                }
            }
        }

        if (strikeCount == strike && ballCount == ball) {
            return true
        }
        return false
    }
}
