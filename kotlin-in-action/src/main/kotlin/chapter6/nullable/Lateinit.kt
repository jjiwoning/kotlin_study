package chapter6.nullable

class MyService {
    fun perform() = "foo"
}

class MyTest {

    private lateinit var myService: MyService

    fun setup() {
        myService = MyService()
    }
}
