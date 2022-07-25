/*

 1. Make a map of letter to number

 2. traverse string

 3. look ahead for symbols with larger value and subtract

   - other wise add

*/

fun main() {
    println(
        Solution().romanToInt("XV")
    )
}

/*

 1. Make a map of letter to number

 2. traverse string

 3. look ahead for symbols with larger value and subtract

   - other wise add

*/


class Solution {

    val rMap = mapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000
    )

    fun romanToInt(s: String): Int {
        var sum = 0
        var i = 0
        var done = false
        while (i < s.length) {
            when (s[i]) {
                'I' -> {
                    if (i != s.length - 1) {
                        if (s[i + i] == 'V') {
                            sum += 4
                            i += 2
                        } else if (s[i + 1] == 'X') {
                            sum += 9
                            i += 2
                        } else {
                            sum += 1
                            i++
                        }
                    } else {
                        sum += 1
                        i++
                    }
                }

                'X' -> {
                    if (i != s.length - 1) {
                        if (s[i + i] == 'L') {
                            sum += 40
                            i += 2
                        } else if (s[i + 1] == 'C') {
                            sum += 90
                            i += 2
                        } else {
                            sum += 10
                            i++
                        }
                    } else {
                        sum += 10
                        i++
                    }
                }

                'C' -> {
                    if (i != s.length - 1) {
                        if (s[i + i] == 'D') {
                            sum += 400
                            i += 2
                        } else if (s[i + 1] == 'M') {
                            sum += 900
                            i += 2
                        } else {
                            sum += 100
                            i++
                        }
                    } else {
                        sum += 100
                        i++
                    }
                }

                'V' -> {
                    sum += 5
                    i++
                }

                'L' -> {
                    sum += 50
                    i++
                }

                'D' -> {
                    sum += 500
                    i++
                }

                'M' -> {
                    sum += 1000
                    i++
                }
            }
        }

        return sum
    }
}
