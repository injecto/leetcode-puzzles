package org.injecto.leetcode

fun longestPalindrome(s: String): String {
    if (s.isEmpty())
        return s
    
    var result = 0..0
    for ((i, c) in s.withIndex()) {
        var p = getPalindromeWithMedian(s, i, i)
        if (p.length() > result.length())
            result = p

        val prevI = i - 1
        if (i <= 0 || c != s[prevI])
            continue

        p = getPalindromeWithMedian(s, prevI, i)
        if (p.length() > result.length())
            result = p
    }

    return s.substring(result)
}

private fun IntRange.length() = endInclusive - start + 1

private fun getPalindromeWithMedian(seq: CharSequence, leftMedianIdx: Int, rightMedianIdx: Int): IntRange {
    var l = leftMedianIdx
    var r = rightMedianIdx
    while (true) {
        if (l < 0 || r >= seq.length)
            break

        if (seq[l] != seq[r])
            break

        l--
        r++
    }

    return (l+1)..(r-1)
}