package google_mock.heights;

import java.util.Arrays;

public class Heights {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] h = new int[]{1,1,4,2,1,3};

        /*

      1,1,4,2,1,3 // switch 4 and 2

      1,1,2,4,1,3 // switch 4 and 1

      1,1,2,1,4,3 // switch 2 and 1

      1,1,2,4,1,3 // switch 4 and 1

      1,1,2,1,4,3 //

      1,1,2,1,4,3

      1,1,2,4,1,3



         */




        int sln = s.heightChecker(h);

        System.out.println(sln);
        System.out.println(Arrays.toString(h));


    }
}

class Solution {
    public int heightChecker(int[] heights) {
        boolean stop = false;
        int count = 0;
        while(stop == false) {

            int mark = -1;

            for (int i = 0; i < heights.length-1; i++) {
                if (heights[i+1] < heights[i]) {
                    mark = i;
                    count++;
                    break;
                }
            }

            if (mark == -1) {
                stop = true;
            } else {
                switchints(mark, heights);
            }

        }

        return count;

    }

    void switchints(int i, int[] a) {
        int temp = a[i+1];
        a[i+1] = a[i];
        a[i] = temp;
    }
}
