package max_product_of_three;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

public class MaxProductOfThree {

    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(s.maximumProduct(new int[]{1, 2, 3}) == 6, "first");
        Assert.that(s.maximumProduct(new int[]{1, 2, 3, 4}) == 24, "second");
        Assert.that(s.maximumProduct(new int[]{-1, -2, -3}) == -6, "third");
        Assert.that(s.maximumProduct(new int[]{-10, -10, -10}) == -1000, "4th");
        Assert.that(s.maximumProduct(new int[]{-100, -2, -3, 1}) == 300, "5th");
        Assert.that(s.maximumProduct(new int[]{-1, -2, 1, 2, 3}) == 6, "6th");
        Assert.that(s.maximumProduct(new int[]{-8, -7, -2, 10, 20}) == 1120, "7th");

    }

}

class Solution {

    public int maximumProduct(int[] nums) {

        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        if (nums.length == 4) {
            Arrays.sort(nums);
            return Math.max(
                    nums[0] * nums[1] * nums[3],
                    nums[1] * nums[2] * nums[3]
            );
        }

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;
        int e = Integer.MIN_VALUE;

        for (int i : nums) {

            // sort smallest
            if (i < b) {
                if (i > a) {
                    b = i;
                } else {
                    b = a;
                    a = i;
                }
            }
            // sort largest

            if (i > c) {
                if (i > d) {
                    if (i > e) {
                        c = d;
                        d = e;
                        e = i;
                    } else {
                        c = d;
                        d = i;
                    }
                } else {
                    c = i;
                }
            }

        }

        return Math.max(
                a * b * e,
                c * d * e
        );

    }

}