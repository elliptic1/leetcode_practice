package remove_vowels;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveVowels {
    public static void main(String[] args) {
        Solution s = new Solution();

        String test = "aqwerfdsoiup";

        System.out.println(s.removeVowels(test));
    }
}

class Solution {
    public String removeVowels(String s) {

        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);

        String solution = m.replaceAll("");

        return solution;

    }
}
