package basic.variable.null_check_java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    // 코틀린 어노테이션을 활용하여 null 체크를 해줘야 한다.
    @NotNull
//    @Nullable
    public String getName() {
        return this.name;
    }
}
