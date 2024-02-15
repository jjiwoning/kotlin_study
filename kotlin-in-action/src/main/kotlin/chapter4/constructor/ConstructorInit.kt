package chapter4.constructor

// 주 생성자, 생성자 private
open class User private constructor(val nickname: String)

// 기반 클래스가 있는 경우 기반 클래스의 생성자를 불러줘야 한다.
class InstagramUser(nickname: String) : User2(nickname)

// 주 생성자를 풀어서 본 코드
open class User2 constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

class User3(
    val nickname: String,
    val isSubscribed: Boolean = true
)

fun main() {
    val user = User3("hello")
}
