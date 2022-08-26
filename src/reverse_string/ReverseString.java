package reverse_string;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[] in = new char[]{'a', 'b', 'c'};
        char[] out = new char[]{'c', 'b', 'a'};
        s.reverseString(in);
        System.out.println(Arrays.toString(in));
        Assert.that(Arrays.equals(out, in), "1");

        char[] in2 = new char[]{'a', 'b', 'c', 'd'};
        char[] out2 = new char[]{'d', 'c', 'b', 'a'};
        s.reverseString(in2);
        System.out.println(Arrays.toString(in2));
        Assert.that(Arrays.equals(out2, in2), "2");
    }
}

class Solution {
    public void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length/2; i++) {
            temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
}
