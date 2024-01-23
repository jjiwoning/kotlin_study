package basic.kotlin_class

fun main() {
    val person = Person("tamtam", 12)
    println(person.name) // getter 호출
    person.age = 13 // setter 호출

    val person2 = Person("hosi")
}

/**
 * Kotlin은 필드만 생성하면 getter, setter를 모두 만들어준다.
 * primary constructor는 반드시 존재해야 한다. -> 만약 primary constructor에 파라미터가 1개도 없다면 생략 가능
 */
class Person(
    val name: String, // field + property 생성 됨
    var age: Int
) {

    init {
        // class가 초기화 되는 시점에 호출되는 block -> 클래스 생성 검증 로직 작성하면 좋다.
        if (this.age < 0) {
            throw IllegalArgumentException("나이는 ${age}살일 수 없습니다.")
        }
    }

    constructor(name: String) : this(name, 1) // 부 생성자 -> 최종적으로는 주 생성자를 this로 호출해야 한다.

    constructor() : this("hello") {
        println("hello!") // block를 가질 수 있다.
    }
}

/**
 * 코틀린에서는 default parameter를 권장한다.
 */
class Person2(
    name: String = "hello",
    var age: Int = 0
) {

    // custom getter
    val name = name
        get() = field.uppercase() // field: 자기 자신을 가리키는 예약어

    init {
        // class가 초기화 되는 시점에 호출되는 block -> 클래스 생성 검증 로직 작성하면 좋다.
        if (this.age < 0) {
            throw IllegalArgumentException("나이는 ${age}살일 수 없습니다.")
        }
    }

    val isAdult: Boolean // 함수 대신 property로 만들어줄 수 있다.
        get() = this.age >= 20
    // 객체의 속성이면 property로 만들고 아니면 method로 만드는게 좋다.
}

