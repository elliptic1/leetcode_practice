package jump_game_2;

import java.util.Arrays;

public class JumpGame2 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] test1 = new int[]{2,3,1,1,4};

        System.out.println(s.jump(test1));

    }

}

class Solution {
    public int jump(int[] nums) {

        /*

        ex: nums = [2,3,1,1,4]

        Method:

        1. Start at the end, find min number of jumps
        2. Work backwards down the array, storing the results
        3. return number at array index 0


         */

        int[] minJumps = new int[nums.length];
        Arrays.fill(minJumps, nums.length);

        minJumps[nums.length-1] = 0;

        for (int i = nums.length-1; i >= 0; i--) {

            for (int j = i+1; j<= i+nums[i] && j < nums.length; j++) {
                minJumps[i] = Math.min(
                        minJumps[i], 1+minJumps[j]
                );
            }

        }

        return minJumps[0];

    }
}
