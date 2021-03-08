package bitwise_manip.num_of_steps_to_reduce_to_zero;


public class NumStepsToReduceToZero {
    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(10 + " - " + s.numberOfSteps(10));
        System.out.println(20 + " - " + s.numberOfSteps(20));
        System.out.println(30 + " - " + s.numberOfSteps(30));
        System.out.println(32 + " - " + s.numberOfSteps(32));

    }
}


class Solution {
    public int numberOfSteps(int num) {

        int count = 0;
        int numbits = (int) Math.floor(Math.log(num) / Math.log(2));

//        System.out.println("num bits - " + num + " - " + numbits);

        int temp = num;
        for (int i = 0; i < numbits; i++) {
            int bit = temp & 1;
            if (bit == 1) {
                count += 2;
            } else {
                count += 1;
            }
            temp = temp >> 1;
        }

        if (temp == 1) {
            count += 1;
        }

        return count;

    }
}