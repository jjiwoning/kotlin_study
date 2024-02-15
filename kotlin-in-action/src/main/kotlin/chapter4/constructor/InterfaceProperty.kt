package chapter4.constructor

interface User4 {
    val nickname: String
}

// 주 생성자에 있는 프로퍼티를 활용하는 방법
class PrivateUser(override val nickname: String) : User4 {

}

// 커스텀 getter 활용하는 방법
class SubscribingUser(val email: String) : User4 {
    override val nickname: String
        get() = email.substringBefore('@')
}

// 프로퍼티 초기화 식 활용하는 방법
class FacebookUser(val accountId: Int) : User4 {
    override val nickname: String = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "${accountId}"
    }
}
