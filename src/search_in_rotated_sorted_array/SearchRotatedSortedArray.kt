package search_in_rotated_sorted_array

fun main() {

}

class Solution {
    fun search(nums: IntArray, target: Int): Int {

        // split in half, see if left or right contains the pivot by checking the endpoints

        // decide which peice to search

        // repeat

        // index pointers
        var left = 0
        var right = nums.lastIndex

        while (left < right) {

            if (right - left < 6) {
                (left..right).forEach { idx ->
                    if (nums[idx] == target) {
                        return idx
                    }
                }
                return -1
            } else {

                val middle = kotlin.math.floor((right-left)/2f).toInt()

                // check left
                if (left < middle) {
                    // no pivot
                    if (left <= target && target <= middle) {
                        right = middle
                    } else {

                    }
                } else {
                    // check right
                    if (middle < right) {
                        // no pivot
                        if (middle <= target && target <= right) {
                            left = middle
                        } else {

                        }
                    }
                }

            }

        }

        return -1

    }


}