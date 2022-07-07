package leet_code_232.avg_pass_ratio;

public class AveragePassRatio {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] classes = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int es = 4;

        System.out.println(s.maxAverageRatio(classes, es));

    }


}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        double[] avgs = new double[classes.length];

        for (int i = 0; i < classes.length; i++) {
            avgs[i] = 1.0 * classes[i][0] / classes[i][1];
        }

        for (int i = 0; i < extraStudents; i++) {

//            System.out.println("avgs is " + Arrays.toString(avgs));

            double maxChange = Double.MIN_VALUE;
            int maxIndex = -1;
            for (int j = 0; j < classes.length; j++) {
                double change = 1.0 * (classes[j][0] + 1) / (classes[j][1] + 1) - avgs[j];
                if (change > maxChange) {
                    maxChange = change;
                    maxIndex = j;
                }
            }

//            System.out.println("maxIndex is " + maxIndex);

            classes[maxIndex][0]++;
            classes[maxIndex][1]++;
            avgs[maxIndex] = 1.0 * classes[maxIndex][0] / classes[maxIndex][1];

//            System.out.println("new ratio is " + avgs[maxIndex]);
//            System.out.println("avgs is " + Arrays.toString(avgs));
//            System.out.println("--------");
        }

        double avgSum = 0.0;

        for (double d : avgs) {
            avgSum += d;
        }

        return avgSum / avgs.length;

    }
}