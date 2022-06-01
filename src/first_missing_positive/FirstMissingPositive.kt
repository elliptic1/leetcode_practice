package first_missing_positive

import sun.jvm.hotspot.utilities.Assert

fun main() {
    println(Solution().firstMissingPositive(intArrayOf(4,1,2,5)))

    test()
}

fun test() {
    val s1 = Solution().firstMissingPositive(intArrayOf(4,1,2,5))
    Assert.that(s1 == 3, "3")
}

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        (1 .. nums.size).map {
            if (!nums.contains(it)) {
                return it
            }
        }
        return nums.size+1
    }
}