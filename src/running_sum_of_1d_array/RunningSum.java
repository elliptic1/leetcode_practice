package running_sum_of_1d_array;

import java.util.Arrays;

public class RunningSum {
public static void main(String[] args) {
    Solution s = new Solution();

    int[] nums = new int[]{1,2,3};

    int[] sol = s.runningSum(nums);

    System.out.println(Arrays.toString(sol));
}

}

class Solution {
    public int[] runningSum(int[] nums) {
        int subtotal = 0;
        int[] sol = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            subtotal += nums[i];
            sol[i] = subtotal;
        }
        return sol;
    }
}