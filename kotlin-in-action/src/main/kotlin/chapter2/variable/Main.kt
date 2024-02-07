package chapter2.variable

val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"

val answer = 42

val yearsToCompute: Double = 7.5e6

fun main() {
    val message: String

    if (canMake()) {
        message = "hello"
    } else {
        message = "bye"
    }

    println("$message user!")
}

fun canMake(): Boolean {
    return true
}
