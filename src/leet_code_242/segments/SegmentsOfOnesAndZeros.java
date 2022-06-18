package leet_code_242.segments;

import sun.jvm.hotspot.utilities.Assert;

public class SegmentsOfOnesAndZeros {
    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(s.checkZeroOnes("1101"), "1");
        Assert.that(!s.checkZeroOnes("111000"), "2");
        Assert.that(!s.checkZeroOnes("110100010"), "3");
    }
}

class Solution {
    public boolean checkZeroOnes(String s) {
        /**
         * Should be O(n) algo
         * 1 pass through string
         * keep track of currently known longest sequence length for 0 and 1
         * keep track of the current sequence, 0 or 1, and length
         * replace if current becomes longest
          */

        int longestZero = 0;
        int longestOne = 0;
        char prevInt = s.charAt(0);
        int currentLength = 0;
        boolean switched = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switched = c != prevInt;

            if (switched) {
                // find current length
                // save it if it's the biggest
                switch (prevInt) {
                    case '0':
                        if (currentLength > longestZero) {
                            longestZero = currentLength;
                        }
                        break;
                    case '1':
                        if (currentLength > longestOne) {
                            longestOne = currentLength;
                        }
                        break;
                }
                // reset counter
                currentLength = 1;
            } else {
                ++currentLength;
            }

            prevInt = c;
        }

        // Run one more time for the end of the string
        switch (prevInt) {
            case '0':
                if (currentLength > longestZero) {
                    longestZero = currentLength;
                }
                break;
            case '1':
                if (currentLength > longestOne) {
                    longestOne = currentLength;
                }
                break;
        }

        return longestOne > longestZero;

    }

}