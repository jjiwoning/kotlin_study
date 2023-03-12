package algo.P11720

fun main(args: Array<String>) {

    val n = readln().toInt()
    val s = readln()

    var answer = 0;

    for (i in s.indices) {
        answer += (s[i] - '0')
    }

    println(answer)
}