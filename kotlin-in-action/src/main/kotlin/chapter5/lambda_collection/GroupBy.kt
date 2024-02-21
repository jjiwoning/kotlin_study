package chapter5.lambda_collection

import chapter5.lambda.Person

fun main() {
    val people = listOf(Person("hello", 21), Person("hello2", 23), Person("hello3", 21))
    val result = people.groupBy { it.age }

    println(result)
}
