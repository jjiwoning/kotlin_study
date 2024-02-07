package chapter1.list1_1

// data class
data class Person(val name: String, val age: Int? = null) // null이 될 수 있는 타입과 파라미터 디폴트 값

fun main() {
    val persons = listOf(Person("영희"),
        Person("철수", age = 11)) // named parameter 활용

    val oldest = persons.maxByOrNull { it.age ?: 0 } // 람다식과 엘비스 연산자

    println("나이가 가장 많은 사람 = ${oldest}") // String template
}
