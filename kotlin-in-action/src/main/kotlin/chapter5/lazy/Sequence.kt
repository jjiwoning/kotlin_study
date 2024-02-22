package chapter5.lazy

import chapter5.lambda.Person

fun main() {
    val people = listOf(Person("hello", 21), Person("hello2", 23), Person("hello3", 21))

    // Java Stream하고 비슷함
    // 시퀀스 내 연산 순서에 따라 성능 차이가 발생할 수 있다.
    val result = people.asSequence()
        .map { it.name }
        .filter { it.startsWith("h") }
        .toList()

    println(result)

    // 자연수의 시퀀스 생성
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}
