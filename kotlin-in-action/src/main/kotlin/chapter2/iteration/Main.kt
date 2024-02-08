package chapter2.iteration

fun main() {
    for (i in 1..100) {
        println(fizzBuzz(i))
    }

    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    val list = listOf(1, 2, 3, 4, 5)

    for (i in list) {
        println(i)
    }
}

fun fizzBuzz(num: Int): String {
    return when {
        num % 15 == 0 -> "FizzBuzz"
        num % 3 == 0 -> "Fizz"
        num % 5 == 0 -> "Buzz"
        else -> "${num}"
    }
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'
