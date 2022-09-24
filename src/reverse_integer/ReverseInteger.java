package reverse_integer;

import sun.jvm.hotspot.utilities.Assert;

import java.nio.CharBuffer;
import java.util.stream.Collectors;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(123 == s.reverse(321), "1");
        Assert.that(123 == s.reverse(321000), "2");
        Assert.that(-1 == s.reverse(-1), "3");
        Assert.that(1 == s.reverse(1), "4");
        Assert.that(-123 == s.reverse(-321), "5");

        Assert.that(0 == s.reverse(Integer.MAX_VALUE), "max");
        Assert.that(0 == s.reverse(Integer.MIN_VALUE), "min");

    }
}

class Solution {
    boolean hasSign;
    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        hasSign = false;
        if (x < 0) {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            hasSign = true;
            x = -x;
        }
        String rint = reverseString(Integer.toString(x));

        // Remove leading zeroes
        int i =0;
        while (rint.charAt(i) == '0') {
            ++i;
        }
        rint = rint.substring(i);

        if (hasSign) {
            rint = "-" + rint;
        }

//        System.out.println(rint);
        int ans = 0;
        try {
            ans = Integer.parseInt(rint);
        } catch (NumberFormatException e) {
            return 0;
        }

        return ans;
    }

    private String reverseString(String s) {
        char[] r = s.toCharArray();
        reverseString(r);
        String joined = CharBuffer.wrap(r).chars()
                .mapToObj(intValue -> String.valueOf((char) intValue))
                .collect(Collectors.joining(""));
        return joined;
    }

    private void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length/2; i++) {
            temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
}


