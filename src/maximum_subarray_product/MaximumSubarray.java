package maximum_subarray_product;

import sun.jvm.hotspot.utilities.Assert;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(s.maxProduct(new int[]{2, 3, -2, 4}) == 6, "first");
        Assert.that(s.maxProduct(new int[]{-2, 0, -1}) == 0, "second");
        Assert.that(s.maxProduct(new int[]{2, 0}) == 2, "third");
        Assert.that(s.maxProduct(new int[]{0, 2}) == 2, "4th");
        Assert.that(s.maxProduct(new int[]{-4, -3, -2}) == 12, "5th");
        Assert.that(s.maxProduct(new int[]{3, -1, 4}) == 4, "6th");

    }
}

class Solution {
    public int maxProduct(int[] nums) {

        int cMax = nums[0];
        int cMin = cMax;
        int globalMax = cMax;

        for (int i = 1; i < nums.length; i++) {
//            System.out.println();
//            System.out.println("Checking out " + nums[i]);
            if (cMax == 0 && cMin == 0) {
//                System.out.println("zero was hit, resetting to " + nums[i]);
                cMax = cMin = nums[i];
            } else {
                if (nums[i] > 0) {
                    cMax = Math.max(nums[i], cMax * nums[i]);
                    cMin = Math.min(nums[i], cMin * nums[i]);
                } else if (nums[i] < 0) {
                    int temp = cMax;
                    cMax = Math.max(nums[i], cMin * nums[i]);
                    cMin = Math.min(nums[i], temp * nums[i]);
                } else {
                    cMax = 0;
                    cMin = 0;
                }
            }
            if (cMax > globalMax) {
//                System.out.println("Found a new global max: " + cMax);
                globalMax = cMax;
            }
        }

        return globalMax;

    }
}
