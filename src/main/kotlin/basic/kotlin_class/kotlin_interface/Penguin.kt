package basic.kotlin_class.kotlin_interface

class Penguin : Flyable, Swimable {

    override fun act() {
        super<Flyable>.act() // 중복되는 인터페이스 메서드 구분 방법
        super<Swimable>.act()
    }

    override fun swim() {
        println("swim1")
    }

    override fun fly() {
        println("fly1")
    }

    override val swimAbility: Int
        get() = super.swimAbility
}
