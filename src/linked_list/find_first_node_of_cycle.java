package linked_list;


public class find_first_node_of_cycle {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

//        head.next.next.next = head;

        ListNode c = s.detectCycle(head);

        if (c != null) {
            System.out.println(c.val);
        } else {
            System.out.println("No cycle");
        }

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        new ListNode(x, null);
    }

    ListNode(int x, ListNode n) {
        val = x;
        next = n;
    }
}

class Solution {

    public ListNode detectCycle(ListNode head) {

        int cycleLength = findCycleLength(head);

        if (cycleLength == -1) return null;

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < cycleLength; i++) {
            fast = fast.next;
        }

        while (slow.val != fast.val) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    int findCycleLength(ListNode head) {
        int dist = -1;
        if (head == null || head.next == null) {
            return -1;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        dist = 1;

        if (slow.val == fast.val) {
            return dist;
        }

        while (fast != null && fast.next != null) {

            if (slow == fast) {
                return dist;
            }

            ++dist;
            slow = slow.next;
            fast = fast.next.next;
        }

        return -1;

    }
}


/*

Use slow and fast pointers to determine existence of a cycle.

Keep track of distance, will tell us cycle length.

reset pointers to head and head + distance, move both along until values match.

solution is value of head when there's a value match


*/

