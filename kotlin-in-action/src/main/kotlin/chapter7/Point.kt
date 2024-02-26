package chapter7

import java.math.BigDecimal

data class Point(val x: Int, val y: Int) {

    // 연산자 오버로딩
    operator fun plus(other: Point): Point {
        return Point(this.x + other.x, this.y + other.y)
    }

    operator fun times(scale: Double): Point {
        return Point(x * scale.toInt(), y * scale.toInt())
    }
}

// 복합 연산자 오버로딩
operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}

// 단항 연산자 오버로딩
operator fun Point.unaryMinus(): Point {
    return Point(-this.x, -this.y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE
