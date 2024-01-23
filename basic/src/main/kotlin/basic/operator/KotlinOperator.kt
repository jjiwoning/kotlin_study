package basic.operator

/**
 * Kotlin Operator
 * 1. 단항 / 산술
 * 2. 비교 연산자, 동등성, 동일성
 * 3. 논리 연산자, 코틀린 만의 연산자
 * 4. 연산자 오버로딩
 */
fun main() {
    // 단항 연산자: ++, --
    // 산술 연산자: +, -, *, /, %
    // 산술 대입 연산자: +=, -=, *=, /=, %=
    var a = 1
    a++
    val b = a * 3
    a -= 2

    // 비교 연산자: >, >=, <=, <
    // Java와는 다르게 객체 간 비교 연산자가 호출되면 compareTo를 호출한다.
    val money1 = Money(100L)
    val money2 = Money(300L)
    println(money1 < money2) // compareTo가 호출 된다.

    // 동등성, 동일성
    // 동등성: 두 객체의 값이 같은가 Kotlin: ==
    // 동일성: 두 객체가 완전히 동일한가 -> 참조가 같은가 Kotlin: ===
    val money3 = Money(100L)
    val money4 = money1
    println(money1 === money4) // true
    println(money1 == money3) // true
    println(money1 == money2) // false

    // 논리 연산자: &&, ||, !
    // Kotlin도 Lazy 연산 지원

    // in, !in
    // 컬렉션이나 범위에 포함되어 있다, 있지 않다를 표현하는 연산자 -> Python하고 같은

    // a..b
    // a부터 b까지 범위 객체를 생성

    // a[i]
    // a에서 특정 인덱스 i로 값을 가져온다.
    // a[i] = b 형식도 가능

    val money5 = money1 + money2 // 연산자 오버로딩
    println(money5)
}

class Money(val amount: Long) : Comparable<Money> {

    // 연산자 오버로딩
    // 코틀린에서는 연산자를 직접 오버로딩 가능
    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }

    override fun compareTo(other: Money): Int {
        return this.amount.compareTo(other.amount)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        return amount.hashCode()
    }

    override fun toString(): String {
        return "Money(amount=$amount)"
    }

}