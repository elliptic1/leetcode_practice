package leet_code_229.merge_strings;

import sun.jvm.hotspot.utilities.Assert;

public class MergeStrings {
    public static void main(String[] args) {
        Solution s = new Solution();

        String w1 = "qwerty";
        String w2 = "zxc";

        String expected = "qzwxecrty";

        Assert.that(s.mergeAlternately(w1, w2).equals(expected), "failed");

        w1 = "zxc";
        w2 = "qwerty";

        expected = "zqxwcerty";

        Assert.that(s.mergeAlternately(w1, w2).equals(expected), "failed");

        w1 = "";
        w2 = "qwerty";

        expected = "qwerty";

        Assert.that(s.mergeAlternately(w1, w2).equals(expected), "failed");

        w1 = "a";
        w2 = "a";

        expected = "aa";

        Assert.that(s.mergeAlternately(w1, w2).equals(expected), "failed");
    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {

        String[] w1 = word1.split("");
        String[] w2 = word2.split("");

        int length = Math.min(w1.length, w2.length);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i< length; i++) {
            sb.append(w1[i]);
            sb.append(w2[i]);
        }
        if (length < w1.length) {
            sb.append(word1.substring(length, word1.length()));
        } else if (length < w2.length) {
            sb.append(word2.substring(length, word2.length()));
        }
        return sb.toString();

    }
}
