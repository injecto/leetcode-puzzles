package org.injecto.leetcode

import java.lang.IllegalArgumentException

fun twoSum(nums: IntArray, target: Int): IntArray {
    require(nums.size > 1)

    val elements = HashMap<Int, MutableList<Int>>()

    for ((i, v) in nums.withIndex()) {
        val addend = target - v

        val idxs = elements[addend]
        if (idxs != null) {
            return intArrayOf(idxs.first(), i)
        }

        elements.computeIfAbsent(v) { arrayListOf() }
            .add(i)
    }

    throw IllegalArgumentException("Unsolvable")
}

