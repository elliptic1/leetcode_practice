package leet_code_232.string_swap;

import sun.jvm.hotspot.utilities.Assert;

public class StringSwap {
    public static void main(String[] args) {
        Solution s = new Solution();

//        Assert.that(s.areAlmostEqual("bank", "kanb") == true, "1");
//        Assert.that(s.areAlmostEqual("bank", "xsxx") == false, "2");
        Assert.that(s.areAlmostEqual("qqlvguziljnavojtlukwzmgyrqvsqsub", "qqlvgujiljnavoztlukwzmgyrqvsqsub") == true, "3");


    }
}

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
//        System.out.println("s1 is " + s1);
        String[] c1 = s1.split("");
        String[] c2 = s2.split("");
        int a = -1;
        int b = -1;
        boolean possible = false;
        OUTER: for (int i = 0; i < s1.length(); i++) {
//            System.out.println("trying i = " + i + " c1[i] " + c1[i] + " c2[i] " + c2[i]);
            if (!c1[i].equals(c2[i])) {
                // find index to switch with
//                System.out.println("found unequal at index " + i);
                a = i;
                for (int j = i+1; j < s1.length(); j++) {
                    if (!c2[j].equals(c1[j])) {
//                        System.out.println("found index " + j);
                        b = j;
                        possible = true;
                        break OUTER;
                    }
                }
            }
        }

        if (possible) {
            String t = c1[b];
            c1[b] = c1[a];
            c1[a] = t;
        }

        String newS1 = String.join("", c1);
//        System.out.println("Checking if " + newS1 + " = " + s2);

        return newS1.equals(s2);

    }
}
