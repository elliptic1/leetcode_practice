package graphs.detect_cycle;

import java.util.ArrayList;

public class DetectCycleFromEdges {
    public static void main(String[] args) {

        int[][] edges = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 2},
                {3, 5}
        };

        Solution s = new Solution();

        System.out.println(s.detectCycle(edges));

    }


}

class Solution {
    public boolean detectCycle(int[][] edges) {


        return true;
    }
}

class ListNode {
    int val;
    ArrayList<ListNode> nexts = new ArrayList<>();

    ListNode(int x) {
        val = x;
        nexts = null;
    }

    ListNode(int x, ListNode[] nexts) {
        val = x;
//        this.nexts.addAll(nexts);
//        Collections.
    }

//    ListNode addEdge(int[] e) {
//        nexts.
//    }
}
