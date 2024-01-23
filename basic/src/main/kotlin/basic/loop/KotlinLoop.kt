package basic.loop

fun main() {

    // for - each
    val numbers = listOf(1L, 2L, 3L)

    for (number in numbers) { // Java -> for (long number : numbers) {}
        println(number)
    }

    // 일반적인 for 문
    // .. 연산자 -> 범위를 만들어준다. -> 등차수열을 만들어준다.
    // downTo, step은 중위 함수이다. -> 변수(1..5) 함수이름(step) argument(3)
    for (i in 1..5) { // 이상, 이하
        println(i)
    }

    for (i in 5 downTo 1) { // 이상, 이하
        println(i)
    }

    for (i in 1..5 step 3) {
        println(i)
    }

    // while
    var number = 5
    while (number <= 30) {
        println(number)
        number *= 5
    }
}
