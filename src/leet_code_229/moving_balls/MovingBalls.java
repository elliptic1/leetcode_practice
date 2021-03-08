package leet_code_229.moving_balls;

import java.util.Arrays;

public class MovingBalls {
    public static void main(String[] args) {
        Solution s = new Solution();

        String b = "001011";

        System.out.println(Arrays.toString(s.minOperations(b)));
    }
}

class Solution {
    public int[] minOperations(String boxes) {

        String[] ba = boxes.split("");
        int[] solution = new int[ba.length];

        for (int i = 0; i < ba.length; i++) {
            System.out.println("i = " + i);
            int sum = 0;
            for (int j = 0; j < ba.length; j++) {
                System.out.println("j = " + j);
                if (i != j && ba[j].equals("1")) {
                    System.out.println("Adding |" + i + "-" + j + "|");
                    sum += Math.abs(i-j);
                }
            }
            solution[i] = sum;
        }

        return solution;

    }
}

/*

ex: "110"

at each index, sum the distances to all 1's.

So the first array element is 1, second is 1, third is 2 + 1 = 3


for int i = 0 to #boxes:
    sum = 0
    for j = 0 to #boxes && i != j:
        if j == 1:
            sum += abs(i-j)
        end
    end
    set solution[i] = sum
end


 */
