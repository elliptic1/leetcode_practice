package merge_two_binary_trees;

import java.util.Objects;
import java.util.Stack;


public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution s = new Solution();


    }
}


class Solution {
    TreeNode tn;

    Stack<TreeNode> solutionNodes;
    Stack<Pair<TreeNode, TreeNode>> givenNodes;

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        tn = new TreeNode();
        solutionNodes = new Stack<>();
        givenNodes = new Stack<>();

        if (root1 == null && root2 != null) {
            return root2;
        }

        if (root1 != null && root2 == null) {
            return root1;
        }

        if (root1 == null && root2 == null) {
            return null;
        }

        solutionNodes.push(tn);

        givenNodes.push(new Pair<>(root1, root2));

        while (!givenNodes.isEmpty()) {

            // Set the value for the current node
            TreeNode currentNode = solutionNodes.pop();
            Pair<TreeNode, TreeNode> currentPair = givenNodes.pop();

            if (currentPair.fst != null) {
                if (currentPair.snd != null) {
                    currentNode.val = currentPair.fst.val + currentPair.snd.val;
                } else {
                    currentNode.val = currentPair.fst.val;
                }
            } else {
                if (currentPair.snd != null) {
                    currentNode.val = currentPair.snd.val;
                } else {
                    currentNode.val = 0; // Shouldn't be here
                }
            }

            if (currentPair.fst != null && currentPair.fst.left != null
                    || currentPair.snd != null && currentPair.snd.left != null) {
                TreeNode first = currentPair.fst == null ? null : currentPair.fst.left;
                TreeNode second = currentPair.snd == null ? null : currentPair.snd.left;
                givenNodes.push(new Pair<>(first, second));
                currentNode.left = new TreeNode();
                solutionNodes.push(currentNode.left);
            }
            if (currentPair.fst != null && currentPair.fst.right != null ||
                    currentPair.snd != null && currentPair.snd.right != null) {
                TreeNode first = currentPair.fst == null ? null : currentPair.fst.right;
                TreeNode second = currentPair.snd == null ? null : currentPair.snd.right;
                givenNodes.push(new Pair<>(first, second));
                currentNode.right = new TreeNode();
                solutionNodes.push(currentNode.right);
            }

        }

        return tn;

    }
}


class Pair<A, B> {
    public final A fst;
    public final B snd;

    public Pair(A var1, B var2) {
        this.fst = var1;
        this.snd = var2;
    }

    public String toString() {
        return "Pair[" + this.fst + "," + this.snd + "]";
    }

    public boolean equals(Object var1) {
        return var1 instanceof Pair && Objects.equals(this.fst, ((Pair) var1).fst) && Objects.equals(this.snd, ((Pair) var1).snd);
    }

    public int hashCode() {
        if (this.fst == null) {
            return this.snd == null ? 0 : this.snd.hashCode() + 1;
        } else {
            return this.snd == null ? this.fst.hashCode() + 2 : this.fst.hashCode() * 17 + this.snd.hashCode();
        }
    }

    public static <A, B> Pair<A, B> of(A var0, B var1) {
        return new Pair(var0, var1);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}