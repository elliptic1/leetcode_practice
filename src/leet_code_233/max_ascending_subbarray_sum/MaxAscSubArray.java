package leet_code_233.max_ascending_subbarray_sum;

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;

public class MaxAscSubArray {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a1 = new int[] {10,20,30,5,10,50};
        Assert.that(s.maxAscendingSum(a1) == 65, "1");

        int[] a2 = new int[] {10,20,30,40,50};
        Assert.that(s.maxAscendingSum(a2) == 150, "2");

        int[] a3 = new int[] {12,17,15,13,10,11,12};
        Assert.that(s.maxAscendingSum(a3) == 33, "3");

        int[] a4 = new int[] {100,10,1};
        Assert.that(s.maxAscendingSum(a4) == 100, "4");
    }
}

class Solution {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        ArrayList<Integer> sums = new ArrayList<>();
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                sums.add(sum);
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        sums.add(sum);
        int max = Integer.MIN_VALUE;
        for (int i : sums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
