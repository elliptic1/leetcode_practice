package contains_dup;

import java.util.HashMap;

public class ContainsDup {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int[] a = new int[]{1,2,3,1};

        System.out.println(s.containsDuplicate(a));

    }
}

class Solution2 {
    public boolean containsDuplicate(int[] nums) {

        /*


        option 1. add each element to a hash, checking if it exists first

        option 2. add each element to a set, checking if it exists first


         */

        HashMap<Integer, Integer> map = new HashMap<>();

        // O(nums) time
        // O(nums) space
        for (int n : nums) {
            // O(k)
            if (map.containsKey(n)) {
                return true;
            } else {
                // O(k)
                map.put(n, 1);
            }
        }

        return false;

    }
}