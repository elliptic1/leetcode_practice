package leet_code_244.matrix_rotation;

import sun.jvm.hotspot.utilities.Assert;

public class MatrixRotation {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] mat = new int[][]{{0, 1}, {1, 0}};
        int[][] target = new int[][]{{1, 0}, {0, 1}};

        Assert.that(s.findRotation(mat, target) == true, "1");


    }

}

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

        int n = mat.length;

        String targetString = "";
        String matString = "";

        // Make zeroDegree and target string
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                targetString += target[row][col];
                matString += mat[row][col];
            }
        }
//        System.out.println(matString);
//        System.out.println(targetString);

        if (matString.equals(targetString)) return true;

        // Check 90 degrees
        String ninetyStr = "";
        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                ninetyStr += mat[row][col];
            }
        }
//        System.out.println(ninetyStr);
        if (ninetyStr.equals(targetString)) return true;

        // Check 180 degrees
        String oneEightyStr = "";
        for (int row = n - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                oneEightyStr += mat[row][col];
            }
        }
//        System.out.println(oneEightyStr);
        if (oneEightyStr.equals(targetString)) return true;

        // Check 180 degrees
        String twoSeventy = "";
        for (int col = 0; col < n; col++) {
            for (int row = n - 1; row >= 0; row--) {
                twoSeventy += mat[row][col];
            }
        }
//        System.out.println(twoSeventy);
        if (twoSeventy.equals(targetString)) return true;

        return false;
    }


}
