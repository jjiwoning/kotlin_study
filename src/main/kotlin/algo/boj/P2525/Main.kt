package algo.boj.P2525

fun main(args: Array<String>) {
    val (h, m) = readln().split(" ").map { it.toInt() }
    val time = readln().toInt()
    val totalTime = 60 * h + m + time

    var answerHour : Int = totalTime / 60
    if (answerHour >= 24) {
        answerHour -= 24;
    }
    val answerMin = totalTime % 60

    print(answerHour)
    print(" ")
    print(answerMin)
}