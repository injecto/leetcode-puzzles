package org.injecto.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll
import kotlin.random.Random

class TwoSumTest: StringSpec({
    "sum of two works" {
        checkAll(Arb.list(Arb.int(), 2..1000)) { list ->
            val fst = Random.nextInt(list.size)
            var snd = 0
            do {
                snd = Random.nextInt(list.size)
            } while (fst == snd)

            val target = list[fst] + list[snd]

            val (actualFst, actualSnd) = Solution().twoSum(list.toIntArray(), target)
            list[actualFst] + list[actualSnd] shouldBe target
        }
    }

    "duplicates test" {
        forAll(
            row(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
            row(intArrayOf(3, 3), 6, intArrayOf(0, 1))
        ) { arr, target, expected ->
            Solution().twoSum(arr, target) shouldBe expected
        }
    }
})