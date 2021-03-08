package linked_list.find_cycle;

public class FindCycle {
    public static void main(String[] args) {


        ListNode n = new ListNode(3);
        n.next = new ListNode(2);
        n.next.next = new ListNode(0);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = n.next;

        Solution s = new Solution();
        System.out.println(s.hasCycle(n));

    }
}

class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            System.out.println("Comparing " + slow.val + " and " + fast.val);

            if (slow.val == fast.val) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;

        }


        return false;

    }

//    public boolean hasCycle(ListNode head) {
//
//        if (head == null) return false;
//
//        HashSet visited = new HashSet<Integer>();
//
//        ListNode temp = head;
//
//        visited.add(temp.val);
//
//        while (temp.next != null) {
//            temp = temp.next;
//
//            if (visited.contains(temp.val)) {
//                return true;
//            } else {
//                visited.add(temp.val);
//            }
//        }
//
//        return false;
//
//    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
