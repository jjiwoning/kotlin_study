package chapter5.lambda

data class Person(val name: String, val age: Int)

fun main() {
    val people = listOf(Person("hello", 12), Person("bye", 28))

    val result = people.maxByOrNull { it.age } // 람다

    val result2 = people.maxByOrNull(Person::age) // 멤버 참조

    val result3 = people.maxByOrNull { person -> person.age } // 정식으로 사용한 람다 식

    println(result)

    // 람다식 기본 문법
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 3))
}
