package algo.boj.P2931

import java.util.*

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

var n: Int = -1
var m: Int = -1
lateinit var map: Array<Array<Char>>
lateinit var visited: Array<Array<Boolean>>

lateinit var target1: Answer
lateinit var target2: Answer

var findX = -1
var findY = -1

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    map = Array(n) {Array(m) {'.'} }

    val target = mutableListOf<Answer>()

    for (i in 0 until n) {
        st = StringTokenizer(readLine())
        val s = st.nextToken()
        for (j in 0 until m) {
            map[i][j] = s[j]
            if (s[j] == 'M' || s[j] == 'Z') {
                target.add(Answer(i, j, s[j]))
            }
        }
    }

    target1 = target[0] // 출발
    target2 = target[1] // 도착

    var x = -1
    var y = -1

    for (i in 0 until 4) {
        val mx = target1.n + dx[i]
        val my = target1.m + dy[i]

        if (mx < 0 || mx >= n || my < 0 || my >= m) {
            continue
        }

        if (map[mx][my] != '.' && map[mx][my] != 'M' && map[mx][my] != 'Z') { // 시작 지점
            x = mx
            y = my
        }
    }

    visited = Array(n) {Array(m) {false} }
    dfs(x, y)

    var up = false
    var down = false
    var left = false
    var right = false

    for (i in 0 until 4) {
        val mx = findX + dx[i]
        val my = findY + dy[i]

        if (mx < 0 || mx >= n || my < 0 || my >= m) {
            continue
        }

        when (i) {
            0 -> {
                if (map[mx][my] == '+' || map[mx][my] == '|' || map[mx][my] == '2' || map[mx][my] == '3') {
                    down = true
                }
            }

            1 -> {
                if (map[mx][my] == '+' || map[mx][my] == '|' || map[mx][my] == '1' || map[mx][my] == '4') {
                    up = true
                }
            }

            2 -> {
                if (map[mx][my] == '+' || map[mx][my] == '-' || map[mx][my] == '3' || map[mx][my] == '4') {
                    right = true
                }
            }

            3 -> {
                if (map[mx][my] == '+' || map[mx][my] == '-' || map[mx][my] == '1' || map[mx][my] == '2') {
                    left = true
                }
            }
        }
    }

    if (up && down && left && right) {
        println("${findX + 1} ${findY + 1} ${'+'}")
        return
    }

    if (up && down) {
        println("${findX + 1} ${findY + 1} ${'|'}")
        return
    }

    if (right && down) {
        println("${findX + 1} ${findY + 1} ${'1'}")
        return
    }

    if (right && up) {
        println("${findX + 1} ${findY + 1} ${'2'}")
        return
    }

    if (left && up) {
        println("${findX + 1} ${findY + 1} ${'3'}")
        return
    }

    if (left && down) {
        println("${findX + 1} ${findY + 1} ${'4'}")
        return
    }

    if (left && right) {
        println("${findX + 1} ${findY + 1} ${'-'}")
        return
    }
}

fun dfs(
    x: Int,
    y: Int,
) {

    if (x < 0 || x >= n || y < 0 || y >= m) {
        return
    }

    if (visited[x][y]) {
        return
    }

    if (map[x][y] == '.') {
        findX = x
        findY = y
        return
    }

    visited[x][y] = true

    when (map[x][y]) {
        '|' -> {
            dfs(x + 1, y)
            dfs(x - 1, y)
        }
        '-' -> {
            dfs(x, y - 1)
            dfs(x, y + 1)
        }
        '+' -> {
            dfs(x + 1, y)
            dfs(x - 1, y)
            dfs(x, y - 1)
            dfs(x, y + 1)
        }
        '1' -> {
            dfs(x + 1, y)
            dfs(x, y + 1)
        }
        '2' -> {
            dfs(x - 1, y)
            dfs(x, y + 1)
        }
        '3' -> {
            dfs(x - 1, y)
            dfs(x, y - 1)
        }
        '4' -> {
            dfs(x + 1, y)
            dfs(x, y - 1)
        }
    }
}

data class Answer(
    val n: Int,
    val m: Int,
    var type: Char
)
