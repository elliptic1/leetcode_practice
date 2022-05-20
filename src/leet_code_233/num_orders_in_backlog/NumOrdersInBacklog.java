package leet_code_233.num_orders_in_backlog;

public class NumOrdersInBacklog {
    public static void main(String[] args) {
//        Solution s = new Solution();

        int[] o1 = new int[]{10, 5, 0};
        int[] o2 = new int[]{15, 2, 1};
        int[] o3 = new int[]{25, 1, 1};
        int[] o4 = new int[]{30, 4, 0};

        int[][] ex1 = new int[4][3];
        ex1[0] = o1;
        ex1[1] = o2;
        ex1[2] = o3;
        ex1[3] = o4;

//        Assert.that(s.getNumberOfBacklogOrders(ex1) == 6, "1");

        o1 = new int[]{7, 1000000000, 1};
        o2 = new int[]{15, 3, 0};
        o3 = new int[]{5, 999999995, 0};
        o4 = new int[]{5, 1, 1};

        int[][] ex2 = new int[4][3];
        ex2[0] = o1;
        ex2[1] = o2;
        ex2[2] = o3;
        ex2[3] = o4;

//        Assert.that(s.getNumberOfBacklogOrders(ex2) == 999999984, "2");


    }
}

//class Solution {
//
//    ArrayList<int[]> bb = new ArrayList<>(); // sort descending
//    ArrayList<int[]> sb = new ArrayList<>(); // sort ascending
//
//    public int getNumberOfBacklogOrders(int[][] orders) {
//
//        for (int[] order : orders) {
//
//            if (order[2] == 0) { // buy
//
//                if (sb.size() == 0) {
//                    addToBuyBacklog(order);
//                    return -1;
//                }
//
//                while (order[1] > 0) {
//                    int[] sell_backorder = sb.get(0);
//                    if (sell_backorder[0] < order[0]) { // selling price is less than buy offer
//
//                        if (sell_backorder[1] < order[1]) {
//                            // there aren't enough orders here to satisfy the incoming buy
//
//                            // get the next order, repeat
//
//                        } else if (sell_backorder[1] == order[1]) {
//                            // sell_bo exactly satisfies this buy order
//                        } else {
//                            // there are more than enough sell_bo to satisfy this buy order
//                            // leave sell_bo on the backlog but subtract order[1] from its qty at index [1]
//                        }
//
//                    }
//                }
//            }
//
//        } else{ // sell
//
//            if (bb.size() == 0) {
//                addToSellBacklog(order);
//            }
//
//        }
//
//    }
//
//
//}
//
//    private void addToBuyBacklog(int[] order) {
//        for (int i = 0; i < bb.size(); i++) {
//            if (order[0] > bb.get(i)[0]) {
//                bb.add(i, order);
//                break;
//            }
//        }
//        bb.add(order);
//    }
//
//    private void addToSellBacklog(int[] order) {
//        for (int i = 0; i < sb.size(); i++) {
//            if (order[0] < sb.get(i)[0]) {
//                sb.add(i, order);
//                break;
//            }
//        }
//        sb.add(order);
//    }
//}