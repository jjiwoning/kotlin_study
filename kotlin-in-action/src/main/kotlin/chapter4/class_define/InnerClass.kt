package chapter4.class_define

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}
