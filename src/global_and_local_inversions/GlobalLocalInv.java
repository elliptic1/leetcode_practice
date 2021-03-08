package global_and_local_inversions;

public class GlobalLocalInv {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A = new int[]{1,0,2};

        System.out.println(s.isIdealPermutation(A));
    }
}

class Solution {
    public boolean isIdealPermutation(int[] A) {

        for (int i=0; i<A.length-1; i++) {
            for (int j=i+2; j<A.length; j++) {
                if (A[i] > A[j]) {
                    return false;
                }
            }
        }

        return true;

    }
}

/*
1. Count global inversions
2. Count local inversions
3. Compare

---> Too slow

1. Notice that all local inversions are global inversions
2. Find an instance of a global inversion that's not local, return false
3. Otherwise return true

 */
