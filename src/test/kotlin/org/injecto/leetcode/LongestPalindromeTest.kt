package org.injecto.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LongestPalindromeTest: StringSpec({
    "longest palindrome test" {
        forAll(
                row("", ""),
                row("x", "x"),
                row("babad", "bab"),
                row("cbbd", "bb"),
                row("арозаупаланалапуазора", "арозаупаланалапуазора"),
                row("хехарозаупаланалапуазора", "арозаупаланалапуазора"),
                row("хехарозаупаланалапуазорахе", "ехарозаупаланалапуазорахе"),
                row("ababababababababababa", "ababababababababababa"),
                row("abababababababababab", "abababababababababa")
        ) { str, result ->
            longestPalindrome(str) shouldBe result
        }
    }
})