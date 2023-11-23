package basic.variable.type

/**
 * Kotlin Type
 */
fun main() {

    // 기본 타입: 코틀린은 선언된 기본 값을 보고 타입을 추론
    val num1 = 3 // Int
    val num2 = 3L // Long
    val num3 = 3.0f // float
    val num4 = 3.0 // double

    // 코틀린의 기본 타입 간 변환은 명시적으로 이루어져야 한다.
    val intNum = 3
    val longNum: Long = intNum.toLong() // 명시적으로 타입 캐스팅을 해야한다.

    // nullable 변수의 경우 아래와 같은 작업을 해줘야 한다.
    val intNumNullable: Int? = 3
    val longNum2: Long = intNumNullable?.toLong() ?: 0L // NPE 발생 가능 -> Safe call + Elvis 연산자를 활용 해야한다.

    // Any Type
    // Java의 Object 역할
    // 기본 타입의 최상위 타입도 Any
    // Any 자체는 Null이 될 수 없으므로 Null이 되야 한다면 Any?
    // equals, hashCode, toString

    // Unit Type
    // Java의 void 역할
    // void와 다르게 Unit 그 자체를 타입 인자로 사용 가능하다.
    // 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 가지는 타입을 의미한다. -> 실제 존재하는 타입이라는 것을 표현하는 용도

    // Nothing Type
    // 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
    // 무조건 예외가 터지는 함수 or 무한 루프 함수 등에서 사용된다.

    // String Interpolation
    val person = Person("hello")
    val message = "안녕하세요 ${person.name}" // ${변수}를 사용하면 값이 들어간다.
    val hello = "hello"
    val message2 = "안녕하세요 $hello" // 일반 변수면 중괄호 생략 가능

    // Java 17에 추가된 기능
    val message3 = """
        hello
        hello
        $hello
    """.trimIndent()

    // String indexing
    val c = message[0] // Java: chatAt() -> 배열 형식으로 가져올 수 있다.
}

/**
 * 클래스 타입의 형 변환
 */
fun castingClassType(obj: Any?) {
    if (obj is Person) { // Java: instanceof
        val person = obj as Person // Java: (Person) obj Kotlin에서는 is Person 형식으로 타입 체크를 해주면 굳이 as를 안해줘도 된다.
        println(person.name)
    }
    if (obj !is Person) { // Java: !(instanceof Person)
        println("Not Person")
    }
    // null check
    val person = obj as? Person // null이 될 수 있는 Person이 된다.
    println(person?.name ?: "noname")
}

class Person(val name: String) {

}