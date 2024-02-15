package chapter4.constructor

import org.omg.CORBA.Context
import javax.print.attribute.AttributeSet

open class View {
    constructor(context: Context) { //부생성자
    }

    constructor(context: Context, attr: AttributeSet) {
    }
}

class MyButton : View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)
}
