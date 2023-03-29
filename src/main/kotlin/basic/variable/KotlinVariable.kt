package basic.variable

data class Person(var name: String, var age: Int, var gender: String)
/**
 * 코틀린 기초) 변수
 * 변수는 val(불변)과 var(가변)이 있다.
 * 코틀린의 타입은 기본형이 없다. -> Java와의 차이 -> 실행시에 기본형으로 바뀌고 코드 자체는 객체형으로 보임
 * -> 개발자가 박싱, 언박싱에 대한 고려를 하지 않아도 된다.
 * 평소에 변수를 선언할 때는 val로 선언하고 필요한 경우 var로 바꾸자.
 * 코틀린의 null이 가능한 변수는 type?로 표현한다.
 */
fun main() {

    // 코틀린은 컴파일러가 type을 추론해준다. -> 동적 언어의 성질을 가진다.

    // var은 가변(바꿀 수 있는) 변수
    var number = 10L
    number = 30L // 가능

    // val은 불변 변수 -> java의 final 키워드와 같음
    val number1 = 10L
//    number1 = 30L -> 불가능

    // 타입을 지정해주고 싶을 때는 아래의 방식을 사용한다.
    val number3: Int

    // 만약 변수에 초기 값을 지정하지 않은 경우
    // 타입을 명시해야됨 -> 컴파일러가 타입 추론을 못 함
//    var number4 // 불가능
    var number4: Long

    // val의 또 다른 특성 -> 선언만 있는 경우 최초 1번은 값 할당 가능
    val number5: Long
    number5 = 11L

    // val 컬렉션에는 element를 추가할 수 있다.
    // -> 컬렉션 자체는 못 바꾸지는 내부의 원소들은 추가, 삭제 등 가능하다 -> 자바도 같음
    val list: ArrayList<Int> = arrayListOf()
    list.add(5)
    list.add(7)
    println(list[1])

    // null 처리 방법
    // 코틀린은 기본적으로 모든 변수에 null을 넣을 수 없게 설계됨
    var number6 = 3000
//    number6 = null // 불가능
    var number7: Long? = 3000L
    number7 = null

    // 객체 변수 선언 방법
    val person = Person("tamtam", 12, "man")
}