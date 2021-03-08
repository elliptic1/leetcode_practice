package number_of_decodings;

import java.util.Arrays;

public class NumDecodings {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numDecodings("226"));

    }
}

class Solution {
    public int numDecodings(String s) {
        int nw = 0;
        try {
            nw = numDecodings(s.split(""), nw);
        } catch (Exception e) {
            return -1;
        }
        return nw;
    }

    int numDecodings(String[] s, int nw) {

        if (s[0].equals("0")) {
            throw (new IllegalStateException());
        }

        if (s.length == 1) {
            return 1;
        }

        switch (s[0]) {
            case "0":
                throw (new IllegalStateException());
            case "1":
                if (s.length > 2) {
                    nw++;
                    numDecodings(Arrays.copyOfRange(s, 1, s.length), nw);
                    numDecodings(Arrays.copyOfRange(s, 2, s.length), nw);
                } else {
                    numDecodings(Arrays.copyOfRange(s, 1, s.length), nw);
                }
            case "2":
                int second = Integer.valueOf(s[1]);
                if (second <= 6) {
                    if (s.length > 2) {
                        nw++;
                        numDecodings(Arrays.copyOfRange(s, 1, s.length), nw);
                        numDecodings(Arrays.copyOfRange(s, 2, s.length), nw);
                    } else {
                        numDecodings(Arrays.copyOfRange(s, 1, s.length), nw);
                    }
                } else {
                    numDecodings(Arrays.copyOfRange(s, 1, s.length), nw);
                }
            default:
                numDecodings(Arrays.copyOfRange(s, 1, s.length), nw);

        }

        return nw;
    }

}

/*


The number of ways to decode "12345" is =

1 + the number of ways to decode "2345"

+

1 + the number of ways to decode "345"


loop through indices,

if chars[i] == 1 or chars[i] == 2 and chars[i+1] == 0-6 then

add one to numOfWays,
remove single digit from array,
add numWaysToDecode(remainingChars)

add (if digits are 11-19 or 20-26)

add one to numOfWays,
remove double digits
add numWaysToDecode(remainingChars)


ex: 1234

NoW(1234) = 1 + NoW(234) +                 1 + NoW(34)
=           1 + 1 + NoW(34) + 1 + NoW(4) + 1 + 1 + NoW(4)
=           1 + 1 + 2       + 1 + 1      + 1 + 1 + 1
= 9

ex: 987

= 1 + NoW(87)
= 1 + 1 + NoW(7)
= 1 + 1 + 1
= 3




ex: 226 = "2", "26"
        = "2", "2", "6"
        = "22", "6"
NoW(226) = 1

 */


