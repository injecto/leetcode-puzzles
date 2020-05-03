package org.injecto.leetcode

fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    val currentSubstringChars = HashMap<Char, Int>()
    var currentSubstringLen = 0
    var currentSubstringStart = 0

    for ((i, c) in s.withIndex()) {
        currentSubstringChars[c]?.let { alreadyExistIdx ->
            val iterator = currentSubstringChars.iterator()
            for (entry in iterator) {
                if (entry.value <= alreadyExistIdx) iterator.remove()
            }

            result = maxOf(result, currentSubstringLen)
            currentSubstringLen -= (alreadyExistIdx - currentSubstringStart + 1)
            currentSubstringStart = alreadyExistIdx + 1
        }

        currentSubstringChars[c] = i
        currentSubstringLen++
    }

    return maxOf(result, currentSubstringLen)
}
