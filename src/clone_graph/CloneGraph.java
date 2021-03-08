package clone_graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
    public static void main(String[] args) {
        Solution s = new Solution();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node clone = s.cloneGraph(n1);

        System.out.println(clone);
    }
}

class Node {
    public int val;
    public ArrayList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val + " - ");
        sb.append("[");
        for (Node n : neighbors) {
            sb.append(n.val);
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}


class Solution {

    ArrayList<Pair<Integer, Integer>> edges = new ArrayList<>();
    HashMap<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {

//        System.out.println("clone called with val " + node.val + ", neighbors " + node.neighbors);

        Node newNode = new Node(node.val, new ArrayList<>());


        nodes.put(newNode.val, node);

        for (Node n : node.neighbors) {
//            System.out.println("checking node " + node.val + " with neighbor " + n.val);
            Pair<Integer, Integer> edge = getSortedPair(node.val, n.val);
            if (!edges.contains(edge)) {
//                System.out.println(node.val + " adding " + n.val);
                edges.add(edge);
                newNode.neighbors.add(cloneGraph(n));
            } else {
//                System.out.println(" already traversed");
                newNode.neighbors.add(nodes.get(n.val));
            }
        }

//        System.out.println("returning node " + node.val);
        return newNode;

    }

    Pair<Integer, Integer> getSortedPair(int a, int b) {
        if (b >= a) {
            return new Pair<>(a, b);
        } else {
            return new Pair<>(b, a);
        }
    }
}


/*

0. Make a global list visitedList.
1. Given a Node n, make a new Node with the same value.
   Add value to visitedList.
2. Make a new list of neighbors.
   For each neighbor of n, if it's not in visitedList,
     add the result of cloneGraph(neighbor) to neighbors.










 */

