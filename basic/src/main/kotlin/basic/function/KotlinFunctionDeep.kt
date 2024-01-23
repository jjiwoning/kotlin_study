package basic.function

/**
 * 확장 함수: 특정 클래스 내부에 있는 메서드처럼 호출할 수 있지만 메서드 자체는 밖에서 만드는 함수
 * infix 함수: 변수 함수이름 argument 형태의 함수
 * inline 함수: 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우
 * 지역 함수: 함수 내부에 함수를 선언할 수 있다.
 */
fun main() {

    val s = "hello!"
    println(s.lastChar())

    val sum = 3 addNumber 4 // infix
    val num = 3
    val addNumber = num.addNumber(4) // 이렇게도 사용 가능
    println(sum)
    println(addNumber)
}

/**
 * 확장 함수
 * 확장 함수는 클래스 내의 private, protected 멤버를 가져올 수 없다. -> 캡슐화 위반
 * 확장 함수와 기존 함수의 시그니처가 동일하면 기존 함수가 이긴다.
 */
fun String.lastChar(): Char {
    return this[this.length - 1] // this를 통해 실제 인스턴스에 접근 가능
}

/**
 * infix 함수
 */
infix fun Int.addNumber(other: Int): Int {
    return this + other
}

/**
 * inline 함수
 * 함수를 파라미터로 전달할 때 오버헤드가 줄어드는 장점
 * 조금 신중하게 써야한다.
 */
inline fun hello(name: String): String {
    return "hello ${name}"
}


/**
 * 지역 함수
 */
fun local(name: String, city: String) {
    fun valid(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException()
        }
    }

    valid(name)
    valid(city)
}
