package org.injecto.leetcode

import java.lang.Math.addExact
import java.lang.Math.multiplyExact
import kotlin.math.absoluteValue
import kotlin.math.sign

fun reverse(x: Int): Int {
    val sign = x.sign

    if (x == Int.MIN_VALUE)
        return 0

    var result = 0
    var current = x.absoluteValue
    try {
        while (current != 0) {
            val rem = current.rem(10)
            current /= 10
            result = addExact(multiplyExact(result, 10), rem)
        }
    } catch (e: ArithmeticException) {
        return 0
    }

    return sign * result
}