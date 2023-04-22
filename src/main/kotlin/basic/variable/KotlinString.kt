package basic.variable

fun main() {
    // 코틀린의 문자열 비교
    // 동등 비교 -> ==
    // 동일 비교 -> ===
    val s1 = "hello"
    val s2 = "hello"

    println(s1 == s2)
    println(s1 === s2) // String pool 에서 값을 가져오기 때문에 동일하다.

    // 문자열 붙이기 -> + 사용
    val s3 = "hi"
    val s4 = "kotlin"
    val concatString = s3 + " " + s4
    println(concatString)

    // 문자열 템플릿
    // $변수명 사용
    val s5 = "kotlin"
    println("반가워 $s5!!")
}