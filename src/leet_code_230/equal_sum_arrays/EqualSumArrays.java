package leet_code_230.equal_sum_arrays;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

public class EqualSumArrays {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] ex1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] ex12 = new int[]{1, 1, 2, 2, 2, 2};
        Assert.that(s.minOperations(ex1, ex12) == 3, "first one failed");

        int[] ex2 = new int[]{1, 1, 1, 1, 1, 1, 1};
        int[] ex22 = new int[]{6};
        Assert.that(s.minOperations(ex2, ex22) == -1, "second one failed");

        int[] ex3 = new int[]{6, 6};
        int[] ex32 = new int[]{1};
        Assert.that(s.minOperations(ex3, ex32) == 3, "third one failed");

    }
}

class Solution {
    int nops = 0;
    public int minOperations(int[] nums1, int[] nums2) {

        if (getMaxSum(nums1) < getMinSum(nums2)
                || getMinSum(nums1) > getMaxSum(nums2)) {
            return -1;
        }

        while (getSum(nums1) != getSum(nums2)) {
            ++nops;
            subProblem(nums1, nums2);
        }

        return nops;

    }

    private void subProblem(int[] a, int[] b) {
        if (getSum(a) < getSum(b)) {
            int diff = getSum(b) - getSum(a);
            System.out.println("a = " + Arrays.toString(a));
            System.out.println("b = " + Arrays.toString(b));
            System.out.println("diff is " + diff);
            // So I need to add diff to an element of a or subtract it from b
            // Try for an exact op
            int index_to_change = -1;
            int new_value = -1;
            for (int ai = 0; ai < a.length; ai++) {
                for (int j = Math.min(6, diff); j > 2; j--) {
                    if (a[ai] == 7-j) {
                        index_to_change = ai;
                        new_value = j;
                    }
                }
            }
            diff = -diff;
            for (int bi = 0; bi < a.length; bi++) {
                for (int j = Math.max(6, diff); j > 2; j--) {
                    if (b[bi] == 7-j) {
                        index_to_change = bi;
                        new_value = j;
                    }
                }
            }
        }
    }

    private int getMinSum(int[] a) {
        return a.length;
    }

    private int getMaxSum(int[] a) {
        return 6 * a.length;
    }

    private int getSum(int[] a) {
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        return sum;
    }
}

/*

Calculate min and max sum for each array, if they can't be equalized, return -1

Find which array has the largest sum



 */