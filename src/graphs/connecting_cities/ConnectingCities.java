package graphs.connecting_cities;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectingCities {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minimumCost(3, new int[][]{
                {1, 2, 5},
                {1, 3, 6},
                {2, 3, 1}
        }));

    }
}

class Solution {
    public int minimumCost(int N, int[][] connections) {

        /*
        1. Find the MST
        2. Add all edge weights
         */


        sortConnections(connections);

        System.out.println(connections);


        return 1;
    }

    public boolean containsCycle(int[][] edges) {
        return true;
    }

    public int[][] sortConnections(int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));
        return connections;
    }

}

/*

Kruskal's Minimum Spanning Tree alg:
    1. Sort edges by non-decreasing weight
    2. Pick smallest that won't form a cycle
    3. Repeat #2 until there are K-1 edges.

 */