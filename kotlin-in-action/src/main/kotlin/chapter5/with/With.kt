package chapter5.with

fun main() {

}

// with을 활용한 코드
// with은 파라미터가 2개 있는 함수이다.
fun alphabet(): String {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.toString()
    }
}

fun alphabet2() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    this.toString()
}
