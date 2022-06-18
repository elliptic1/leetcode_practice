package leet_code_242.jump_game_7;

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;

public class JumpGameSeven {
    public static void main(String[] args) {
        Solution s = new Solution();

//        Assert.that(s.canReach("01", 1, 1) == false, "0");
        Assert.that(s.canReach("011010", 2, 3) == true, "1");
//        Assert.that(s.canReach("01101110", 2, 3) == false, "2");
//        Assert.that(s.canReach("000100100010", 1, 2) == true, "3");

    }
}

class Solution {
    ArrayList<Integer> memo;
    int minJump = 0;
    int maxJump = 0;

    public boolean canReach(String s, int minJump, int maxJump) {

        memo = new ArrayList<>();

        if (s.charAt(s.length() - 1) == '1') {
            return false;
        }

        memo.add(s.length() - 1);
        this.minJump = minJump;
        this.maxJump = maxJump;

        // look at all chars between s.length-1-maxjump and s.length-1-minjump
        return checkRange(s);

    }

    public boolean checkRange(String s) {
        int minIndex = Math.max(s.length() - 1 - maxJump, 0);
        int maxIndex = s.length() - 1 - minJump;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (s.charAt(i) == '0') {
                if (i == 0) {
                    return true;
                }
                if (!memo.contains(i)) {
                    memo.add(i);
                    String sub = s.substring(0, i + 1);
                    return checkRange(sub);
                }
            }
        }
        return false;
    }
}
