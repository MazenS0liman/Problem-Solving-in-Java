package LeetCode.Tree;

/*
    ----------------------------------------------------------------
    | Problem: Leaf-Similar Trees
    | Link: https://leetcode.com/problems/leaf-similar-trees
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class Leaf_Similar_Trees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // we need to apply breadth-first search,
        // get the leaf sequence of root1 and root2 and compare them
        ArrayList<Integer> root1Sequence = getLeafSequence(root1);
        ArrayList<Integer> root2Sequence = getLeafSequence(root2);

        while (!root1Sequence.isEmpty() && !root2Sequence.isEmpty()) {

            if (!root1Sequence.get(0).equals(root2Sequence.get(0))) {
                return false;
            }
            root1Sequence.remove(0);
            root2Sequence.remove(0);
        }

        return  root1Sequence.isEmpty() && root2Sequence.isEmpty();
    }

    public static ArrayList<Integer> getLeafSequence(TreeNode root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> leafSequence = new ArrayList<>();
        if (root.left == null && root.right == null) {
            leafSequence.add(root.val);
        }
        else {
            ArrayList<Integer> leftSequence = getLeafSequence(root.left);
            ArrayList<Integer> rightSequence = getLeafSequence(root.right);
            leafSequence.addAll(leftSequence);
            leafSequence.addAll(rightSequence);
        }

        return leafSequence;
    }

}
