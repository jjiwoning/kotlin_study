package basic.variable.null_check_java

fun main() {
    val person = Person(null)
    startWithA(person.name)
}

fun startWithA(str: String): Boolean {
    return str.startsWith("A")
}