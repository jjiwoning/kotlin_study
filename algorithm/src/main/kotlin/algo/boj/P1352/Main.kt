package algo.boj.P1352

import java.util.TreeMap

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val list = mutableListOf<Int>()

    var count = n
    var sum = 0

    for (i in 1..n) {
        if (i >= 27) {
            println(-1)
            return
        }
        if (count < i) {
            println(-1)
            return
        }
        if (count > i) {
            if (count - i < i + 1) {
                continue
            }
            if (sum + 1 < i) {
                println(-1)
                return
            }
            list.add(i)
            sum += i
            count -= i
            continue
        }
        if (count == i) {
            if (count - i < i + 1) {
                continue
            }
            if (sum + 1 < i) {
                println(-1)
                return
            }
            list.add(i)
            break
        }
    }

//    println(list)

    val answer = CharArray(n) {'!'}
    val map = TreeMap<Char, Int>()

    for (i in 0 until list.size) {
        map['A' + i] = list[i] - 1
        answer[list[i] - 1] = 'A' + i
    }

    var index = 0

    for (key in map.keys) {
        repeat(map[key]!!) {
            while (true) {
                if (answer[index] == '!') {
                    break
                }
                if (answer[index] != '!') {
                    index++
                }
            }
            answer[index] = key
        }
    }

    println(String(answer))
}
