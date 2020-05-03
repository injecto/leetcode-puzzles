package org.injecto.leetcode

class ListNode(var `val`: Int, var next: ListNode? = null) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListNode

        if (`val` != other.`val`) return false
        if ((next == null) xor (other.next == null)) return false
        if (next == null && other.next == null) return true
        return next == other.next
    }

    override fun toString(): String {
        return "$`val` > $next"
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val root = ListNode(0)
    add(root, l1, l2, 0)
    return root.next
}

private fun add(prev: ListNode, v1: ListNode?, v2: ListNode?, overflow: Int) {
    if (v1 == null && v2 == null) {
        if (overflow > 0)
            prev.next = ListNode(overflow)

        return
    }

    if ((v1 == null) xor (v2 == null)) {
        val vn = v1 ?: v2!!
        prev.next = vn
        val (v, o) = addDigits(vn.`val`, overflow)
        vn.`val` = v
        add(vn, vn.next, null, o)
        return
    }

    if (v1 != null && v2 != null) {
        val (v, o) = addDigits(v1.`val`, v2.`val` + overflow)
        val curr = ListNode(v)
        prev.next = curr
        add(curr, v1.next, v2.next, o)

        return
    }

    throw IllegalStateException("Boolean logic is broken here")
}

private fun addDigits(d1: Int, d2: Int): Pair<Int, Int> {
    val sum = d1 + d2
    return if (sum < 10) {
        sum to 0
    } else {
        sum.rem(10) to 1
    }
}
