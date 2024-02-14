package chapter4.class_define

// open class로 선언하면 상속 가능
open class RichButton: Clickable {

    // 이 메서드는 final로 오버라이드 불가능
    fun disable() {
    }

    // 이 메서드는 open으로 열어 오버라이드 가능
    open fun animate() {
    }

    // 상위 클래스에서 선언된 열린 메서드를 오버라이드 함
    override fun click() {
    }
}
