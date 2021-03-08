package contains_dup;

public class ContainsDup2 {
    public static void main(String[] args) {

        Solution3 s = new Solution3();

        int[] nums = new int[]{1, 2, 3};

        int k = 3;

        System.out.println(s.containsNearbyDuplicate(nums, k));

    }

}

class Solution3 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        /*
        Given an array of integers and an integer k, find out whether
        there are two distinct indices i and j in the array such that
        nums[i] = nums[j] and the absolute difference between i and j
        is at most k.

        ex: nums = {1,2,1,3}, k = 1 // false
        ex: nums = {1,1,2,3}, k = 1 // true


        */

        // O(nums.length * k) time
        // O(nums.length) space
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<Math.min(i+k+1, nums.length); j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;


    }
}
