package leet_code_1480

fun main() {
    Solution().runningSum(intArrayOf(1,2,3,4,5).reversedArray())
}

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val currentSum = 0
        val runningSum: MutableList<Int> = mutableListOf() // O(n) space
        nums.mapIndexed{ idx, n -> // O(n) time
            if (idx == 0) {
                runningSum.add(nums[idx])
            } else {
                runningSum.add(nums[idx] + runningSum[idx-1])
            }
        }
        return runningSum.toIntArray()
    }
}