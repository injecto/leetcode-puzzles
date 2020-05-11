package org.injecto.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ReverseIntegerTest: StringSpec({
    "reverse integer test" {
        forAll(
                row(0, 0),
                row(1, 1),
                row(123, 321),
                row(-123, -321),
                row(120, 21),
                row(Int.MAX_VALUE, 0),
                row(2147447412, 2147447412),
                row(Int.MIN_VALUE, 0)
        ) { int, result ->
            reverse(int) shouldBe result
        }
    }
})