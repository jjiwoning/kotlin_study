package basic.variable

fun main(args: Array<String>) {

    var str: String = "Hello"

    for (c in str) {
        println(c)
    }

    str += 6
    println(str)

    println(str.uppercase())
}