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

        // Look for a 1. If none, return 1
        // O(n) time
        if (!nums.contains(1)) {
            return 1
        }

        // Change all negative and out of range ints to 1
        // O(n) time
        (0..nums.lastIndex).map { i ->
            if (nums[i] < 1 || nums[i] > nums.size) {
                nums[i] = 1
            }
        }

        println("all positive")
        println(nums.toList())

        // Change sign of elements of num to indicate presence
        (0..nums.lastIndex).map { i ->
            println("checking if ${nums[i]} == ${nums.size}")
            val value = kotlin.math.abs(nums[i])
            if (value == nums.size) {
                if (nums[0] > 0) {
                    nums[0] = -1 * nums[0]
                }
            } else {
                if (nums[value] > 0) {
                    nums[value] = -1 * nums[value]
                }
            }
        }

        println("signs changed")
        println(nums.toList())

        // Look for first positive number
        (1..nums.lastIndex).map { i ->
            if (nums[i] > 0) {
                return i
            }
        }
        if (nums[0] > 0) {
            return nums.size
        }

        // Else return the next highest number
        return nums.size + 1

    }
}