package basic.kotlin_class.visibility_modifier

/**
 * public: 모든 곳에서 접근 가능
 * protected: 선언된 클래스 또는 하위 클래스에서 접근 가능
 * internal: 같은 모듈에서만 접근 가능 -> Java에서는 public으로 인식한다.
 * private: 선언된 클래스 내에서만 사용 가능
 *
 * kotlin의 기본 접근 제어자 = public
 */
val num = 10 // public

private val num2 = 20

internal val num3 = 30

open class Protect protected constructor(
    name: String
) {
    protected var a = 10 // protected는 파일 최상단에서 작성 불가

    var name = name
        private set // setter에 추가적인 가시성 부여 가능
}