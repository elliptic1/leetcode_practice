package number_connected_components_in_undirected_graph.adjacency_matrix;

import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] test = new int[][]{{1, 0}, {2, 6}, {1, 7}, {5, 1}, {6, 4}, {7, 0}, {0, 5}, {5, 1}, {6, 4}};

        System.out.println(s.countComponents(8, test));

    }

}

class Solution {

    boolean[][] adj;

    HashSet<Integer> notvisited = new HashSet<>();
    int componentCount = 0;
    int n;

    ArrayList<HashSet<Integer>> components;

    Queue<Integer> toBeVisited = new PriorityQueue<>();

    public int countComponents(int n, int[][] edges) {

        this.n = n;
        adj = new boolean[n][n];
        components = new ArrayList<>();

        // O(#edges) time
        // O(n^2) space
        for (int[] e : edges) {
            if (e[0] != e[1]) {
                adj[e[0]][e[1]] = true;
                adj[e[1]][e[0]] = true;
            }
        }

        // O(n)
        for (int i = 0; i < n; i++) {
            notvisited.add(i);
        }

        // O(n)
        while (notvisited.size() > 0) {

            ++componentCount;
            System.out.println(componentCount);

            notvisited.stream().findFirst().ifPresent(this::explore);

            // O(n)
            while (toBeVisited.size() > 0) {

                toBeVisited.stream().findFirst().ifPresent(this::explore);

            }

        }

        return componentCount;
    }

    void explore(int i) {

        System.out.println("Exploring " + i);

        notvisited.remove(i);
        toBeVisited.remove(i);

        // O(n)
        for (int j = 0; j < n; j++) {

            if (adj[i][j] && notvisited.contains(j)) {
                toBeVisited.add(j);
            }

        }

    }
}

/*

Solution with an adjacency matrix.
- Make a set of components (to be filled later)
- Make an adjacency matrix (upper diagonal)
- Keep a global list of visited nodes
- Start method - Pick a globally unvisited node
- Make a new temp component (list of int) (may be merged later)
- Add node to visited list
- For each neighbor
    if it is in the visited list
        it must already be in a component
    else
        add to the temp component
        Start again on this neighbor




 */