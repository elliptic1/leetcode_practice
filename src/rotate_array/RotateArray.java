package rotate_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

    public static void main(String[] args) {

        Solution1 s = new Solution1();

        int[] aone = new int[]{1,2};

        int k = 3;

        //
        // {1,2,3,4,5,6,7}
        // starts at index 4 which is length-k
        //
        // ex: rotate by k=1
        // {7,1,2,3,4,5,6}
        // starts at index [length-1-k]
        // i=0 -> 6
        // i=1 -> 0
        // i=2 -> 1
        // i=3 -> 2
        // i=4 -> 3
        // i=5 -> 4
        // i=6 -> 5
        //
        // i=n ->
        //

        s.rotate(aone, k);

        System.out.println("Hello World!");
        System.out.println(Arrays.toString(aone));
    }
}


class Solution1 {

    // O(max(nums.length, k/nums.length))) time
    // O(nums.length) space

    public void rotate(int[] nums, int k) {

        List<Integer> ans = new ArrayList<>();

        // O(nums.length) time
        // O(nums.length) space

        for (int i=0; i<nums.length; i++) {
            System.out.println(Math.floorMod(i + nums.length - k, nums.length));
            ans.add(nums[Math.floorMod(i + nums.length - k, nums.length)]);
        }

        // O(ans.length) time
        // O(ans.length) space
        for (int i=0; i < ans.size(); i++) {
            nums[i] = ans.get(i);
        }
    }
}
