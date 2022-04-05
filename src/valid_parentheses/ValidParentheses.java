package valid_parentheses;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(s.isValid("()"), "1");
        Assert.that(s.isValid("(){}[]"), "2");
        Assert.that(s.isValid("[]{[()()][]}{}"), "3");
        Assert.that(!s.isValid("(){{}]"), "4");
    }
}

class Solution {
    public boolean isValid(String s) {
        int i = 0;
        Stack<Character> chars = new Stack<>();

        while (i < s.length()) {
            switch (s.charAt(i)) {
                case '(':
                    chars.push('(');
                    break;
                case ')':
                    if (chars.size() == 0) {
                        return false;
                    }
                    if (chars.peek().equals('(')) {
                        chars.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    chars.push('[');
                    break;
                case ']':
                    if (chars.size() == 0) {
                        return false;
                    }
                    if (chars.peek().equals('[')) {
                        chars.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    chars.push('{');
                    break;
                case '}':
                    if (chars.size() == 0) {
                        return false;
                    }
                    if (chars.peek().equals('{')) {
                        chars.pop();
                    } else {
                        return false;
                    }
                    break;
            }
            i++;
        }
        if (chars.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
