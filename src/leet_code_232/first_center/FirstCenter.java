package leet_code_232.first_center;

import java.util.ArrayList;

public class FirstCenter {
    public static void main(String[] args) {
        Solution s = new Solution();


    }
}

class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<Integer> seen = new ArrayList<>();

        for (int[] a : edges) {
            for (int b : a) {
                if (seen.contains(b)) {
                    return b;
                } else {
                    seen.add(b);
                }
            }
        }
        return -1;
    }
}
