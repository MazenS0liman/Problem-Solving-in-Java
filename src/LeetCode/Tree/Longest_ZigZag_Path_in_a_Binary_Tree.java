package LeetCode.Tree;

/*
    ----------------------------------------------------------------
    | Problem: Longest ZigZag Path in a Binary Tree
    | Link: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree
    | Status: Time Limit Exceeded
    ----------------------------------------------------------------
*/

public class Longest_ZigZag_Path_in_a_Binary_Tree {

    public int longestZigZag(TreeNode root) {
        return Math.max(Math.max(root.left != null ? helper(root.left, -1) + 1 : 0, root.right != null ? helper(root.right, 1) + 1 : 0), Math.max(root.left != null ? longestZigZag(root.left) : 0, root.right != null ? longestZigZag(root.right) : 0));
    }

    // -1 mean left
    // 1 mean right
    public static int helper(TreeNode root, int direction) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        if (direction == 1) {
            return root.left != null ? helper(root.left, -1) + 1 : 0;
        }
        else {
            return root.right != null ? helper(root.right, 1) + 1 : 0;
        }
    }

}
