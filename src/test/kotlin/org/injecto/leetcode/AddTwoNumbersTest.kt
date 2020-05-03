package org.injecto.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class AddTwoNumbersTest: StringSpec({
    "ListNode equals test" {
        forAll(
            row(ListNode(0)),
            row(ListNode(0, ListNode(1))),
            row(ListNode(1, ListNode(1)))
        ) { l ->
            l shouldBe l
        }
    }

    "toList test" {
        forAll(
            row(0, ListNode(0)),
            row(1, ListNode(1)),
            row(10, ListNode(0, ListNode(1))),
            row(11, ListNode(1, ListNode(1))),
            row(1234, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))
        ) { v, expected ->
             toList(v) shouldBe expected
        }
    }

    "addTwoNumbers test" {
        forAll(
            row(0, 0),
            row(0, 1),
            row(1, 0),
            row(8, 1),
            row(9, 1),
            row(10, 1),
            row(10, 9),
            row(10, 10),
            row(100, 1),
            row(10, 0)
        ) { v1, v2 ->
            val l1 = toList(v1)
            val l2 = toList(v2)
            val expected = toList(v1 + v2)
            addTwoNumbers(l1, l2) shouldBe expected
        }
    }
})

private fun toList(v: Int): ListNode {
    val root = ListNode(0)

    var curr = root
    var n = v
    while (true) {
        val d = n.rem(10)
        curr.`val` = d

        n = (n - d) / 10
        if (n == 0)
            break

        curr.next = ListNode(0)
        curr = curr.next!!
    }

    return root
}