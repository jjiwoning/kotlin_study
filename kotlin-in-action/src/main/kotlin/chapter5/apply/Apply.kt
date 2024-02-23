package chapter5.apply

// apply
fun alphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
}.toString()

fun alphabet2() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
}
