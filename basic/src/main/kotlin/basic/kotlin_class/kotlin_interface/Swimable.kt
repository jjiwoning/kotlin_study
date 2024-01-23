package basic.kotlin_class.kotlin_interface

interface Swimable {

    val swimAbility
        get() = 3

    fun act() {
        println("swim")
    }

    fun swim()
}