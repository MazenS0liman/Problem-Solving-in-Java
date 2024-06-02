package LeetCode.Tree;

/*
    ----------------------------------------------------------------
    | Problem: Maximum Depth of Binary Tree
    | Link: https://leetcode.com/problems/maximum-depth-of-binary-tree
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Maximum_Depth_of_Binary_Tree {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) { // empty tree
            return 0;
        }
        // base case
        if (root.left == null && root.right == null) {
            return 1;
        }
        // recursive cases
        else if (root.left == null) { // has right subtree only
            return maxDepth(root.right) + 1;
        }
        else if (root.right == null) { // has left subtree only
            return maxDepth(root.left) + 1;
        }
        else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

}
