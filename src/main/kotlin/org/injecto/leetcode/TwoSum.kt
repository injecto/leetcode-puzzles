package org.injecto.leetcode

import java.lang.IllegalArgumentException

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        require(nums.size > 1)

        val elements = nums.withIndex().groupBy({ it.value }) { it.index }
        for ((v, idxs) in elements) {
            val addend = target - v

            val idxs2 = elements[addend]
            if (idxs2 != null) {
                if (idxs === idxs2) {
                    // duplicate
                    if (idxs.size == 1)
                        // same single value
                        continue

                    return intArrayOf(idxs[0], idxs[1])
                }
                return intArrayOf(idxs[0], idxs2[0])
            }
        }


        throw IllegalArgumentException("Unsolvable")
    }
}
