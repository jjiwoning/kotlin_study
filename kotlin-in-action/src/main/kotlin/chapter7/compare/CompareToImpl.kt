package chapter7.compare

class Person(
    val firstName: String,
    val lastName: String
) : Comparable<Person> {

    override fun compareTo(other: Person): Int {
        // 인자로 받은 함수를 차례로 호출하면서 값을 비교
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }

}
