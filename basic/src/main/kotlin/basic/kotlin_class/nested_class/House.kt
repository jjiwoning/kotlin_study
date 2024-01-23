package basic.kotlin_class.nested_class

import java.math.BigDecimal

/**
 * 코틀린은 내부 클래스는 static 표시 안해줘도 static임
 * 바깥 클래스에 대한 연결이 없는 중첩 클래스가 되기 때문에
 * -> Java에서 권장하는 내부 클래스 선언 방법
 */
class House(
    private val address: String,
    private val room: Room
) {
    // 권장되는 방법
    class Room(
        private val area: BigDecimal
    )

    // 나쁜 방법
    inner class Room2 {
        val address: String
            get() = this@House.address // 바깥 클래스 참조 방법
    }
}