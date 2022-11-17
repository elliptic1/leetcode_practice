package leet_code_234;

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;

public class Num_Ints_in_a_String {
    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(s.numDifferentIntegers("a123bc34d8ef34") == 3, "1");
        Assert.that(s.numDifferentIntegers("leet1234code234") == 2, "2");
        Assert.that(s.numDifferentIntegers("a1b01c001") == 1, "3");

    }
}

class Solution {

    ArrayList<Integer> recordedNumbers;
    String[] letters;

    public int numDifferentIntegers(String word) {

        letters = word.split("");

        // special case length = 0

        int start = 0;
        int end = 0;

        recordedNumbers = new ArrayList();

        while (end < word.length()) {

            if (letters[end].matches("[a-z]")) {
                if (letters[end].equals("0") && start == end) { // leading zero
                    start++;
                }
                end++;

                // special case if a number ends the string
                if (end == word.length()) {
                    if (start == end) { // special case, lots of zeros end the string
                        // add zero to recordedNumbers
                    }
//                    addNumber();
                }
            } else { // letters[end] is a letter
                if (end - start > 0) {
//                    addNumber();
                    ++end;
                    start = end;

                }

            }

        }

        return recordedNumbers.size();

    }

//    private Void addNumber() {
//        recordedNumbers.add(Arrays.copyOfRange(letters, start, end)

//    }
}
