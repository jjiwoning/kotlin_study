package basic.kotlin_class.enum_class

enum class Animal(
    private val value: String
) {
    DOG("dog"),
    CAT("cat")
    ;
}

fun main() {
    findAnimal(Animal.DOG)
}

fun findAnimal(animal: Animal) {
    when (animal) {
        Animal.DOG -> println("hello dog")
        Animal.CAT -> println("hello cat")
        // else 작성 안해줘도 된다. -> enum은 컴파일 시점에 어떤 값이 있는지 확인 가능하기 때문에
        // enum에 변화가 있으면 체크해준다 -> 장점
    }
}
