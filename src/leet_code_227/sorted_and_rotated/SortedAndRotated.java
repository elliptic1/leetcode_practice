package leet_code_227.sorted_and_rotated;

public class SortedAndRotated {
    public static void main(String[] args) {

        Solution s = new Solution();

        // True
        int[] ex1 = new int[]{9,1,2,3,4};
        int[] ex2 = new int[]{5,6,7,1,2,3,4};
        int[] ex3 = new int[]{8,9,1,2,3,4};
        int[] ex4 = new int[]{1,2,3,4,6,8,9};
        int[] ex5 = new int[]{1};

        // False
        int[] ex6 = new int[]{1,3,5,7,2,4,6,8};
        int[] ex7 = new int[]{8,6,5,4,2,1};
        int[] ex8 = new int[]{1,2,3,7,6,5};


        System.out.println(s.check(ex1));
        System.out.println(s.check(ex2));
        System.out.println(s.check(ex3));
        System.out.println(s.check(ex4));
        System.out.println(s.check(ex5));
        System.out.println(s.check(ex6));
        System.out.println(s.check(ex7));
        System.out.println(s.check(ex8));

    }
}

class Solution {
    public boolean check(int[] nums) {

//        System.out.println("Starting example " + Arrays.toString(nums));

       /*

       If the array was sorted ascending and then rotated, then I should be able to see if each number is
       greater than or equal to the previous, allowing for one violation of this rule.

       In the case that the array has been rotated,

       {a...b, c...d}

       then it should be true that b >= a, d >= c, a >= d


        Algo:

        1. left to right, check that each digit is >= the previous.
        2. If there is one exception, check that b >= a, d >= c, a >= d


        */

       if (nums.length == 1 || nums.length == 2) {
           return true;
       }

       int a = nums[0];
       int b = 0;
       int c = 0;
       int d = nums[nums.length-1];

       boolean shifted = false;

       for (int i=1; i<nums.length-1; i++) {

           // This can only happen once.
           if (nums[i] < nums[i-1]) {
               if (shifted) {
//                   System.out.println("Shifted too many times");
                   return false;
               }
               b = nums[i-1];
               c = nums[i];
               shifted = true;
           }
       }

       // If we're here then we've only shifted zero or one time.

        if (shifted) {
//            System.out.println("shifted");
            if (b >= a && d >= c && a >= d) {
//                System.out.println("ineq true");
                return true;
            } else {
//                System.out.println("ineq fail");
//                System.out.println("a is " + a);
//                System.out.println("b is " + b);
//                System.out.println("c is " + c);
//                System.out.println("d is " + d);
                return false;
            }
        } else {
//            System.out.println("not shifted");
            return true;
        }
    }
}
