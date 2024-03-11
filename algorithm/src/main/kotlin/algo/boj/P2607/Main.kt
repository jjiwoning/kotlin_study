package algo.boj.P2607

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val target = readLine()

    var answer = 0

    for (i in 0 until n - 1) {
        if (isSimilarWord(target, readLine())) {
            answer++
        }
    }

    println(answer)
}

// 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸어 나머지 한 단어와 같은 구성을 갖게 되는 경우에 이들 두 단어를 서로 비슷한 단어라고 한다.
private fun isSimilarWord(
    targetString: String,
    compareString: String
): Boolean {
    var result = compareString
    if (targetString.length == compareString.length) {
        for (c in targetString) {
            result = result.replaceFirst(c.toString(), "")
        }
        return result.length < 2
    }
    if (targetString.length > compareString.length) {
        result = targetString
        for (c in compareString) {
            result = result.replaceFirst(c.toString(), "")
        }
        return result.length < 2
    }
    if (targetString.length < compareString.length) {
        for (c in targetString) {
            result = result.replaceFirst(c.toString(), "")
        }
        return result.length < 2
    }
    return false
}
