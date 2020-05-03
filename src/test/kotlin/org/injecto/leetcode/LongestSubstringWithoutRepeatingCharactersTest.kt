package org.injecto.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LongestSubstringWithoutRepeatingCharactersTest: StringSpec({
    "test" {
        forAll(
            row("abcabcbb", 3),
            row("bbbbb", 1),
            row("pwwkew", 3),
            row("", 0),
            row("dvdf", 3)
        ) { input, res ->
            lengthOfLongestSubstring(input) shouldBe res
        }
    }
})