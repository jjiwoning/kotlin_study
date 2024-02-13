package chapter3.extensionfun.override

open class View {
    open fun click() = println("View Clicked")
}

class Button : View() {
    override fun click() {
        println("Button Clicked")
    }
}

fun View.showOff() = println("I'm View")
fun Button.showOff() = println("I'm Button")

fun main() {
    val view: View = Button()
    view.click()

    view.showOff() // View의 showOff가 실행된다.
}
