package chapter4.`object`

// 싱글톤 클래스
object Payroll {

    private val allEmployees = arrayListOf<Int>()

    fun calculateTotalSalary(): Int {
        return allEmployees.sum()
    }
}

fun main() {
    Payroll.calculateTotalSalary() // 사용 방법
}

data class Hello(val message: String) {
    object Message {
        // 싱글톤이 보장된다.
    }
}
