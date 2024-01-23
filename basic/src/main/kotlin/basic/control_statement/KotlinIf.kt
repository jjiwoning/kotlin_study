package basic.control_statement

fun main() {
    // if 문
    // Java와 차이가 없다.
    // Java if = Statement
    // Kotlin if = Expression
    // Statement: 프로그램의 문장으로 하나의 값으로만 도출되지 않는다.
    // Expression: 하나의 값으로 도출되는 문장
    // Kotlin에서는 3항 연산자가 존재하지 않음 -> if가 Expression이기 때문에
    val state = true
    if (state) {
        println("hello")
    }

    // Expression이기 때문에 이런 방식이 가능하다.
    val s = if (state) {
        "hello"
    } else {
        "bye"
    }
    println(s)

    val num = 50
    val min = 0
    val max = 100
    if (num in min..max) {
        println("hello")
    }

    // Java switch -> Kotlin when -> Expression
    when (num / 10) {
        10 -> println("hello1")
        9 -> println("hello2")
        8 -> println("hello3")
        7 -> println("hello4")
        in 1.. 4 -> println("hello3")
        else -> println("hello123")
    }
}

fun hello(bool: Boolean): String {
    return if (bool) {
        "hello"
    } else {
        "bye"
    }
}