package leet_code_244.reductions;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

public class ReductionOperations {
    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(s.reductionOperations(new int[]{5, 1, 3}) == 3, "1");
        Assert.that(s.reductionOperations(new int[]{1, 1, 1}) == 0, "2");
        Assert.that(s.reductionOperations(new int[]{1, 1, 2, 2, 3}) == 4, "3");
        Assert.that(s.reductionOperations(new int[]{1, 3, 5, 7}) == 6, "4");
        Assert.that(s.reductionOperations(new int[]{1, 3, 5, 7, 8}) == 10, "5");
        Assert.that(s.reductionOperations(new int[]{1, 3, 5, 7, 7}) == 9, "6");
        Assert.that(s.reductionOperations(new int[]{1, 3, 5, 7, 7, 8}) == 13, "7");
        Assert.that(s.reductionOperations(new int[]{49995,49999,49993,49997,49996,50000,49991,49998,49992,49994}) == 45, "8");
        Assert.that(s.reductionOperations(new int[]{5,9,3,7,6,10,1,8,2,4}) == 45, "9");
    }
}


class Solution {
    public int reductionOperations(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return 1;

        Arrays.sort(nums);

        int ops = 0;
        int add = 0;
        int last = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[0]) continue;

            if (last != nums[i]) {
                add++;
                last = nums[i];
            }

            ops += add;

        }

        return ops;
    }
}

class Solution2 {
    public int reductionOperations(int[] nums) {

        if (nums.length == 1) return 0;
        if (nums.length == 2) return 1;

        int ops = 0;

        while (!allAreEqual(nums)) {

            Arrays.sort(nums);

//            System.out.println(" -- BEGIN --");
//            System.out.println(Arrays.toString(nums));

            int largestIndex = nums.length-1;
            int secondLargest = -1;
            for (int i = largestIndex-1; i >= 0; i--) {
                if (nums[i] < nums[largestIndex]) {
                    secondLargest = i;
                }
            }

            for (int i = nums.length-1; i >= 0; i--) {
//                System.out.println("testing " + i + " largest is " + largestIndex);
//                System.out.println("nums[" + i + "] is " + nums[i]);
//                System.out.println("nums[" + largestIndex + "] is " + nums[largestIndex]);
                if (nums[i] > nums[largestIndex]) {
//                    System.out.println("second is " + secondLargest + " setting to " + largestIndex);
                    secondLargest = largestIndex;
//                    System.out.println("setting largest to " + i);
                    largestIndex = i;
                }
                if (nums[i] > nums[secondLargest] && nums[i] < nums[largestIndex]) {
//                    System.out.println(" ---- setting second to " + secondLargest);
                    secondLargest = i;
                }
            }

//            System.out.println("largest index " + largestIndex);
//            System.out.println("second index " + secondLargest);
            nums[largestIndex] = nums[secondLargest];
//            System.out.println(Arrays.toString(nums));
            ++ops;

        }

        return ops;

    }

    private boolean allAreEqual(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[0] != nums[i]) return false;
        }
        return true;
    }
}
