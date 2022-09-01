package leet_code_244.wasted_space;


import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

public class WastedSpace {
    public static void main(String[] args) {

        Solution s = new Solution();


        int[] p = new int[]{2, 3, 5};
        int[][] b = new int[][]{{4, 8}, {2, 8}};
        Assert.that(s.minWastedSpace(p, b) == 6, "1");

        p = new int[]{2, 3, 5};
        b = new int[][]{{1, 4}, {2, 3}, {3, 4}};
        Assert.that(s.minWastedSpace(p, b) == -1, "2");

        p = new int[]{3, 5, 8, 10, 11, 12};
        b = new int[][]{{12}, {11, 9}, {10, 5, 14}};
        Assert.that(s.minWastedSpace(p, b) == 9, "3");
    }
}

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {

        Arrays.sort(packages);

        int minwaste = Integer.MAX_VALUE;

        supplier:
        for (int[] sizes : boxes) {
            Arrays.sort(sizes);

            if (packages[packages.length - 1] > sizes[sizes.length - 1]) {
                continue;
            }

            int swaste = 0;

            for (int aPackage : packages) {
                int pwaste = 0;
                for (int size : sizes) {
                    if (size >= aPackage) {
                        pwaste = size - aPackage;
//                        System.out.println("Adding pwaste " + pwaste);
                        break;
                    }
                }
                swaste += pwaste;
                if (swaste > minwaste) {
                    continue supplier;
                }
//                System.out.println("swaste is now " + swaste);
            }

            if (swaste < minwaste) {
                minwaste = swaste;
//                System.out.println("new min waste is " + minwaste);
            }

        }

        if (minwaste == Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) (minwaste % (Math.pow(10.0, 9.0) + 7));
        }

    }
}
