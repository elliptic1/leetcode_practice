package google.count_sub_matrices;

public class CountSubMatrices {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] m = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};

        System.out.println(s.countSquares(m));

    }
}

class Solution {

    int [][] matrix;

    public int countSquares(int[][] matrix) {

        this.matrix = matrix;

        int maxBoxSize = Math.min(matrix.length, matrix[0].length);

        int numBoxes = 0;

        for (int size = maxBoxSize; size > 0; size--) {
//            System.out.println("Checking size " + size);
            int sn = 0;
            for (int startY = 0; startY <= matrix.length - size; startY++) {
//                System.out.println(" - startY = " + startY);
                for (int startX = 0; startX <= matrix[0].length - size; startX++) {
//                    System.out.println(" - - startX = " + startX);
                    if (isABox(startY, startX, size)) {
                        ++numBoxes;
                        ++sn;
                    }
                }
            }
//            System.out.println("For size " + size + ", there are " + sn);
        }

        return numBoxes;

    }

    private boolean isABox(int startY, int startX, int size) {
//        System.out.println("- checking starty=" + startY + ", startX=" + startX + ", size=" + size);
        for (int i = startY; i < startY + size; i++) {
//            System.out.println("- for y from " + startY + " to " + (startY+size));
            for (int j = startX; j < startX + size; j++) {
//                System.out.println(" - - for x from " + startX + " to " + (startX+size));
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*

Search the entire space for the largest squares, down to the



 */