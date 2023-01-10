package search_in_rotated_sorted_array

import sun.jvm.hotspot.utilities.Assert

fun main() {
    test()
}

fun test() {
    println(Solution().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))

}

class Solution {
    fun search(nums: IntArray, target: Int): Int {

        // split in half, see if left or right contains the pivot by checking the endpoints

        // decide which peice to search

        // repeat

        // index pointers
        val left = 0
        val right = nums.lastIndex

        while (left < right) {

            if (right - left < 6) {
                (left..right).forEach { idx ->
                    if (nums[idx] == target) {
                        return idx
                    }
                }
                return -1
            } else {

                val middle = kotlin.math.floor((right - left) / 2f).toInt()

                // check left for pivot
                val ans1 = if (left <= middle) {
                    // no pivot
                    left + nums
                        .slice(left..middle)
                        .binarySearch(target)
                } else {
                    search(nums.slice(left..middle).toIntArray(), target)
                }

                if (ans1 > -1) {
                    return ans1
                }

                // check right
                val ans2 = if (middle <= right) {
                    // no pivot
                    middle + nums
                        .slice(middle..right)
                        .binarySearch(target)
                } else {
                    search(nums.slice(middle..right).toIntArray(), target)
                }

                if (ans2 > -1) {
                    return ans2
                }

            }
        }

        return -1

    }
}