package leet_code_227.closest_subseq;

import java.util.Arrays;

public class Closest {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minAbsDifference(new int[]{1, 2, 4, 5}, 3));

    }
}

class Solution {
    public int minAbsDifference(int[] nums, int goal) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int diff =
                    Math.min(
                            Math.abs(sum(nums) - goal),
                            minAbsDifference(
                                    Arrays.copyOfRange(nums, 0, i),
                                    Arrays.copyOfRange(nums, i + 1, nums.length),
                                    goal - nums[i]
                            )
                    );
            if (diff < min) {
                min = diff;
            }
        }

        return min;

    }

    int minAbsDifference(int[] r1, int[] r2, int goal) {
        int[] a = new int[r1.length + r2.length];
        for (int i = 0; i < r1.length; i++) {
            a[i] = r1[i];
        }
        for (int i = 0; i < r2.length; i++) {
            a[r1.length + i] = r2[i];
        }
        return minAbsDifference(a, goal);
    }

    int sum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}

/*

For each number, Given the min abs diff of all other numbers, should we keep or remove this number?

ex: {1,2,4,5}, goal 3

Check
{  , 2, 4, 5 } = 11
{  ,  , 4, 5 } = 9
{  ,  ,  , 5 } = 5
{  ,  ,  ,   } = 0

{  ,  ,  , 5 } = 11

{  ,  , 4,   } = 4

{  , 2, 4, 5 } = 11

{ 1, 2, 4, 5 } = 12

 */