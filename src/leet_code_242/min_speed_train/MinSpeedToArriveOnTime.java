package leet_code_242.min_speed_train;

import sun.jvm.hotspot.utilities.Assert;

public class MinSpeedToArriveOnTime {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] dist = new int[]{1,3,2};
        double hour = 6;
//        Assert.that(s.minSpeedOnTime(dist, hour) == 1, "1");


        dist = new int[]{1,3,2};
        hour = 2.7;
        Assert.that(s.minSpeedOnTime(dist, hour) == 3, "2");


        dist = new int[]{1,3,2};
        hour = 1.9;
        Assert.that(s.minSpeedOnTime(dist, hour) == -1, "3");


    }
}

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {

        if (hour < dist.length -1) {
            return -1;
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {

            double sum = 0;

            for (int j = 0; j < dist.length-1; j++) {
                if (dist[j] <= i) {
                    sum++;
                } else {
                    sum += Math.ceil(1.0 * dist[j] / i);
                }
            }
            sum += 1.0 * dist[dist.length-1] / i;

            if (sum <= hour) {
                return i;
            }

        }

        return -1;

    }
}