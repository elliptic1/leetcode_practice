package graphs.find_town_judge;

import java.util.Arrays;
import java.util.HashMap;

public class FindTheTownJudge {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findJudge(1, new int[][]{
        }));

    }
}

class Solution {
    public int findJudge(int N, int[][] trust) {

        if (N == 1 && trust.length == 0) {
            return 1;
        }

        // Step 1 - Find people that trust no one

        HashMap<Integer, Integer> trustsNoOne = new HashMap<>();

        // O(N)
        for (int i = 1; i< N+1; i++) {
            trustsNoOne.put(i, 1);
        }

        // O(N)
        for (int[] t : trust) {
            trustsNoOne.remove(t[0]);
        }

        // trustsNoOne keys are people who trust no one
        log("trusts no one");
        log(trustsNoOne.toString());


        // Step 2 - Find people who everybody trusts

        // O(T)  where T = trust.length
        HashMap<Integer, Integer> trustedBy = new HashMap<>();
        for (int[] t : trust) {
            if (trustedBy.containsKey(t[1])) {
                trustedBy.put(t[1], trustedBy.get(t[1]) + 1);
            } else {
                trustedBy.put(t[1], 1);
            }
        }
        log("trusted by");
        log(trustedBy.toString());

        // values of N-1 imply person corresponding to key are trusted by everyone else


        // Step 3 - The judge is a key of trustsNoOne with a value in trustedBy of N-1


        // O(N)
        for (int k : trustsNoOne.keySet()) {
            if (trustedBy.containsKey(k)) {
                if (trustedBy.get(k) == N-1) {
                    return k;
                }
            }
        }

        return -1;

    }

    void log(String s) {
        System.out.println(s);
    }

    void log(Object[] a) {
        System.out.println(Arrays.toString(a));
    }

}

/*

Given N people, int[][] trust

for i = 0 to N-1, look for i not the first element of any trust pair.

Make a hashmap<int, int> that maps people numbers to how many people they are trusted by

The keys i with values of N-1 are judges.

 */