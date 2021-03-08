package add_two_numbers;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution5 s = new Solution5();

        s.addTwoNumbers(
//                new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9))))))),
//                new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9))))
//                new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(1))),
//                new add_two_numbers.ListNode(1)
//                new add_two_numbers.ListNode(9, new add_two_numbers.ListNode(4, new add_two_numbers.ListNode(9))),
//                new add_two_numbers.ListNode(5, new add_two_numbers.ListNode(6, new add_two_numbers.ListNode(4, new add_two_numbers.ListNode(9))))
                new ListNode(6),
                new ListNode(4)
        );

    }
}

class Solution5 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1.val == 0 && l1.next == null) return l2;
        if (l2.val == 0 && l2.next == null) return l1;

        int len1 = getLength(l1);
        int len2 = getLength(l2);

        ListNode ol1;
        ListNode ol2;

        if (len1 >= len2) {
            ol1 = l1;
            ol2 = l2;
        } else {
            ol2 = l1;
            ol1 = l2;
        }

        ListNode currentNode1;
        ListNode currentNode2;
        ListNode solnNode = new ListNode();
        ListNode tempSolnNode;

        currentNode1 = ol1;
        currentNode2 = ol2;

        int carry = 0;

        tempSolnNode = solnNode;

        while (currentNode1 != null) {
            log("current node is " + currentNode1);
            int val1 = currentNode1.val;
            int val2 = 0;
            if (currentNode2 != null) {
                val2 = currentNode2.val;
            } else {
                val2 = 0;
            }

            int nodeTotal = val1 + val2 + carry;
            log("node total " + nodeTotal);


            if (nodeTotal > 9) {
                carry = 1;
                nodeTotal -= 10;
            } else {
                carry = 0;
            }

            log("carry is " + carry);

            tempSolnNode.val = nodeTotal;

            if (currentNode1.next != null) {
                tempSolnNode.next = new ListNode();
            } else {
                if (carry == 1) {
                    tempSolnNode.next = new ListNode(1);
                }
            }

            currentNode1 = currentNode1.next;
            if (currentNode2 != null && currentNode2.next != null) {
                currentNode2 = currentNode2.next;
            } else {
                currentNode2 = null;
            }

            tempSolnNode = tempSolnNode.next;

        }

        log(solnNode);

        return solnNode;
    }

    int getLength(ListNode l) {
        int len = 0;
        ListNode temp = l;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    void log(String s) {
        System.out.println(s);
    }

    void log(int i) {
        log("" + i);
    }

    void log(ListNode ln) {
        log(ln.toString());
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}



/*

Add vals for all nodes, calculate carry digit, pass to next sum

ex:

2 -> 4 -> 3
4 -> 3

add first nodes together. Add it to the sum of the next nodes, times ten to the power of the recursion depth

depth = 0


 */


