package number_of_good_pairs;

public class GoodPairs {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] test1 = new int[]{1,1,1,1};

        System.out.println(s.numIdenticalPairs(test1));
    }
}

class Solution {
    public int numIdenticalPairs(int[] nums) {

        int gp = 0;

        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ++gp;
                }
            }
        }

        return gp;

    }
}