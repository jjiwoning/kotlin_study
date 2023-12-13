package basic.kotlin_class.sealed_class

/**
 * 상속이 가능하도록 추상 클래스를 만들고자 하는데 외부에서는 해당 클래스를 상속하고 싶지 않을 때 사용
 * 컴파일 시점에 하위 클래스 타입을 모두 기억하고 런타임 때 클래스 타입을 추가할 수 없다.
 * -> enum이랑 비슷해서 when을 사용할 때 장점이 있다.
 *
 * 하위 클래스는 같은 패키지에 있어야 한다.
 *
 * enum과의 차이
 * - 클래스 상속 가능
 * - 인스턴스 여러개 생성 가능
 */
sealed class Person(
    val name: String,
    val age: Int
)

class TamTam : Person("tamtam", 12)
