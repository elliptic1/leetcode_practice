package leet_code_230.closest_dessert;

import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;
import java.util.HashMap;

public class ClosestDessert {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] baseCosts = new int[]{1, 7};
        int[] toppingCosts = new int[]{3, 4};
        int target = 10;

        Assert.that(s.closestCost(baseCosts, toppingCosts, target) == 10, "First one failed");

        int[] baseCosts2 = new int[]{2, 3};
        int[] toppingCosts2 = new int[]{4, 5, 100};
        int target2 = 18;

        Assert.that(s.closestCost(baseCosts2, toppingCosts2, target2) == 17, "First one failed");

    }

}

class Solution {

    int[] costWithBase;
    int[] toppingCosts;
    int target;
    HashMap<Integer, Integer> dp = new HashMap<>();

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

        costWithBase = new int[baseCosts.length];
        this.toppingCosts = toppingCosts;
        this.target = target;

        for (int i = 0; i < baseCosts.length; i++) {
            // calculate closest cost to target with this base
            costWithBase[i] = baseCosts[i] + subProblem(0);

        }

        // find min out of costWithBase array
        return Arrays.stream(costWithBase).min().getAsInt();
    }

    private int subProblem(int i) {
        System.out.println("subProblem " + Arrays.toString(toppingCosts) + " i= " + i);
        if (i == toppingCosts.length) {
            System.out.println("returning 0");
            return 0;
        }
        int[] candidates = new int[3];
        candidates[0] = 0 * toppingCosts[i] + subProblem(i + 1);
        candidates[1] = 1 * toppingCosts[i] + dp.get(i + 1);
        candidates[2] = 2 * toppingCosts[i] + dp.get(i + 1);

        int ret;

        System.out.println("candidates are " + Arrays.toString(candidates));

        if (Math.abs(candidates[0] - target) < Math.abs(candidates[1] - target)) {
            System.out.println("0 < 1");
            if (Math.abs(candidates[0] - target) < Math.abs(candidates[2] - target)) {
                System.out.println("0 < 2");
                ret = candidates[0];
            } else {
                System.out.println("0 > 2");
                ret = candidates[2];
            }
        } else {
            if (Math.abs(candidates[1] - target) < Math.abs(candidates[2] - target)) {
                System.out.println("1 < 2");
                ret = candidates[1];
            } else {
                System.out.println("1 > 2");
                ret = candidates[2];
            }
        }

        dp.put(i, ret);
        System.out.println("Returning " + ret);
        return ret;

    }
}

/*

Return the minimum of the absolute value of the cost - target, where the cost is:
    1 base cost + 0, 1, or 2 of topping one + 0, 1, or 2 of topping two + ...

   for each base flavor, calculate the closest cost to the target.

   return the min

 */
