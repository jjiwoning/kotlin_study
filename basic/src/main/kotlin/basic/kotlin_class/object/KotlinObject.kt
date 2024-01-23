package basic.kotlin_class.`object`

fun main() {
    Person.newPerson("hello")
    Person.MIN_AGE

    Hello.number += 20

    move(object : Moveable{
        override fun move(number: Int): String {
            return "hello${number}"
        }
    })

    move { number: Int ->
        "hello$number"
    }
}

class Person private constructor(
    val name: String,
    val age: Int
) {
    /**
     * static keyword 대신에 사용됨
     * companion object: 클래스와 동행하는 유일한 오브젝트
     * 하나의 객체로 간주된다. -> 네이밍, 인터페이스 구현 가능
     */
    companion object {
        const val MIN_AGE = 0 // const: compile 시점에 변수가 할당된다. -> 진짜 상수에 붙이는 용도 (기본 타입 + String에 붙일 수 있음)
        fun newPerson(name: String): Person {
            return Person(name, MIN_AGE)
        }
    }
}

fun move(moveable: Moveable) {
    println(moveable.move(10))
}

/**
 * Kotlin singleton
 */
object Hello {
    var number = 0
}

fun interface Moveable {
    fun move(number: Int): String
}
