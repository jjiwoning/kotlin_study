fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
        (if (toUpperCase) name.uppercase() else name) + number

fun useFoo() = listOf(
        foo(name = "a"),
        foo(name = "b", number = 1),
        foo(name = "c", toUpperCase = true),
        foo(name = "d", number = 2, toUpperCase = true)
)
