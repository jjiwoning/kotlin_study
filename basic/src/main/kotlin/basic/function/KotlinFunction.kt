package basic.function

fun main() {
    hello(str = "안녕하세요") // named argument 이용하여 함수 call 가능 -> builder의 장점을 가진다.
    hello(number = 1)
    // Kotlin에서 Java 함수를 가져다 쓸 때는 named Argument를 사용할 수 없다.

    hello2("1", "2", "3")
    val arr = arrayOf("1", "2", "9")
    hello2(*arr) // spread 연산자 필요
}

// public 접근 제어자 생략 가능
fun max(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun max(a: Long, b: Long) = // =으로 진행되는 함수는 리턴 타입 생략 가능하다.
    if (a > b) {
        a
    } else {
        b
    }

/**
 * default parameter
 */
fun hello(
    str: String = "hello",
    number: Int = 10,
    newLine: Boolean = true
) {
    for (i in 1..number) {
        if (newLine) {
            println(str)
            continue
        }
        println(str)
    }
}

/**
 * 가변 인자 사용법
 */
fun hello2(vararg str: String) {
    for (s in str) {
        println(s)
    }
}
