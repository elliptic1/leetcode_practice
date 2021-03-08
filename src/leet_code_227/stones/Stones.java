package leet_code_227.stones;

public class Stones {

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.maximumScore(2, 4, 6));
        System.out.println(s.maximumScore(4, 4, 6));
        System.out.println(s.maximumScore(1, 8, 8));
        System.out.println(s.maximumScore(46059, 59117, 67415));
    }


}

class Solution {
    public int maximumScore(int a, int b, int c) {

        // Strategy is take from the two biggest piles every time

        int score = 0;

        // at most one zero pile
        while (a != 0 && b != 0
                || b != 0 && c != 0
                || a != 0 && c != 0) {
            if (a >= b) {
                if (a >= c) {
                    if (b >= c) {
                        // Order is c,b,a

                        score++;

                        b--;
                        a--;

                    } else { // c > b
                        // Order is b,c,a

                        score++;

                        c--;
                        a--;

                    }
                } else { // c > a
                    // Order is b,a,c

                    score++;

                    a--;
                    c--;
                }
            } else { // b > a
                if (a >= c) {
                    if (b >= c) {
                        // Order is c,a,b
                        score++;
                        a--;
                        b--;

                    } else { // c > b
                        // Order is a,b,c
                        score++;
                        b--;
                        c--;


                    }
                } else { // c > a
                    // Order is a,c,b
                    score++;
                    c--;
                    b--;
                }
            }
        }

        return score;
    }


}

/*
4,4,6
3,4,5
3,3,4
2,3,3
2,2,2
1,1,2
0,1,1
0,0,0
 */

/*
2,4,6
2,3,5
2,2,4
1,2,3
1,1,2
0,1,1
0,0,0

 */