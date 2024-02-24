package chapter6.nullable

fun main() {

    val email: String? = null

    email?.let { email -> sendToEmail(email) }
}

fun sendToEmail(email: String) = println("hello~")
