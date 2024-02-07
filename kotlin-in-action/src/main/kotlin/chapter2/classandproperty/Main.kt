package chapter2.classandproperty

class Person(val name: String)

class Person1(
    val name: String, // 읽기 전용 프로퍼티 -> getter
    var isMarried: Boolean // 쓸 수 있는 프로퍼티 -> getter, setter
)

class Rectangle(
    private val height: Int,
    private val width: Int
) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main() {
    val person = Person("tamtam")

    println(person.name)

    val square = Rectangle(5, 5)

    println(square.isSquare)
}