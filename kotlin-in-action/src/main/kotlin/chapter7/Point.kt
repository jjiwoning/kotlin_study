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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
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
