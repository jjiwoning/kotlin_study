package basic.kotlin_class.inheritance

/**
 * 상속 주의 사항
 * 상위 클래스 설계 시 생성자 또는 초기화 블록에서 사용되는 property에는 open을 피해야 한다.
 */
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int // property를 override할 때 open을 붙여줘야 한다.
) {

    abstract fun move()

}

class Cat(
    species: String
) : Animal(species, 4) { // 상위 클래스의 생성자를 바로 호출

    override fun move() {
        println("cat move")
    }

}

class Penguin(
    species: String
) : Animal(species, 2) { // 상위 클래스의 생성자를 바로 호출

    private val wingCount = 2

    override fun move() {
        println("penguin move")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount
}
