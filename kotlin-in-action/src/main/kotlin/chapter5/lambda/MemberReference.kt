package chapter5.lambda

val getAge = Person::age

fun hello() = println("hello!")

fun main() {
    run(::hello)
}
