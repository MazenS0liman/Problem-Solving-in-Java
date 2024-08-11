package LeetCode.Tree;

/*
    ----------------------------------------------------------------
    | Problem: Sum Root to Leaf Numbers
    | Link: https://leetcode.com/problems/sum-root-to-leaf-numbers
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Sum_Root_to_Leaf_Numbers {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, "");
    }

    public int sumNumbersHelper(TreeNode root, String num) {
        if (root.left == null && root.right == null) { // leaf node
            return Integer.parseInt(num + root.val);
        }

        int leftSubTree = root.left != null ? sumNumbersHelper(root.left, num + root.val) : 0;
        int rightSubTree = root.right != null ? sumNumbersHelper(root.right, num + root.val) : 0;
        return leftSubTree + rightSubTree;
    }
}
