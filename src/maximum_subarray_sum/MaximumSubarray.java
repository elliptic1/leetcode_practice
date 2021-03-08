package maximum_subarray_sum;

import sun.jvm.hotspot.utilities.Assert;

public class MaximumSubarray {
    public static void main(String[] args) {

        Solution s = new Solution();

        Assert.that(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6, "first failed");
        Assert.that(s.maxSubArray(new int[]{1}) == 1, "second failed");
        Assert.that(s.maxSubArray(new int[]{5, 4, -1, 7, 8}) == 23, "third failed");

    }
}

class Solution {

    public int maxSubArray(int[] nums) {

        int localMax = nums[0];
        int globalMax = localMax;

        for (int i = 1; i < nums.length; i++) {
            localMax += nums[i];
            if (nums[i] > localMax) {
                localMax = nums[i];
            }
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;

    }

}


/*



 */