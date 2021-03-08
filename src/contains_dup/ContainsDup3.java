package contains_dup;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.TreeSet;

public class ContainsDup3 {
    public static void main(String[] args) {

        Solution4 s = new Solution4();
        int[] nums = new int[]{-2147483648, 2147483647};
        int k = 1;
        int t = 1;
        System.out.println(s.containsNearbyAlmostDuplicate(nums, k, t));

    }

}

class Solution4 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        /*
        Given an array of integers, find out whether there are two distinct indices
        i and j in the array such that the absolute difference between nums[i] and nums[j]
        is at most t and the absolute difference between i and j is at most k.

        ex: nums = {1,2,1,3}, k = 1, t = 1 // false
        ex: nums = {1,1,2,3}, k = 1, t = 1 // true

        make a treeset
        keep a record of the ints in the sliding window
        have only those ints in the tree

        for each int x,
            if queue length is k, remove the first int from the tree
            if tree has x, return true
            check if elements in the tree satisfy conditions relative to x O(log n)
            add x to queue,
            add x to tree,


        */

        TreeSet<Integer> set = new TreeSet<>();

        ArrayDeque<Integer> q = new ArrayDeque<>(k + 1);

        for (int n : nums) {

            if (q.size() == k + 1) {
                int oldest = q.getFirst();
                q.remove(oldest);
                set.remove(oldest);
            }

            if (set.contains(n)) {
                return true;
            }

            try {
                int higher = set.higher(n);
                if (BigInteger.valueOf(higher).subtract(BigInteger.valueOf(n)).compareTo(BigInteger.valueOf(t)) <= 0) {
                    return true;
                }
            } catch (NullPointerException ignore) {

            }

            try {
                int lower = set.lower(n);
                if (BigInteger.valueOf(n).subtract(BigInteger.valueOf(lower)).compareTo(BigInteger.valueOf(t)) <= 0) {
                    return true;
                }
            } catch (NullPointerException ignore) {

            }

            q.add(n);
            set.add(n);

            System.out.println(set);

        }


        return false;

    }
}
