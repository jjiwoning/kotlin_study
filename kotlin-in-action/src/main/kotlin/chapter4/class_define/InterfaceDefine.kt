package chapter4.class_define

interface Clickable {
    fun click()

    fun showOff() = println("I'm Clickable")
}

interface Focusable {
    fun showOff() = println("I'm Focusable")
}

class Button : Clickable, Focusable {
    override fun click() {
        println("I was clicked")
    }

    override fun showOff() {
        super<Focusable>.showOff()
    }

}
