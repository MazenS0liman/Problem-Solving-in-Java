package LeetCode.Tree;

/*
    ----------------------------------------------------------------
    | Problem: Lowest Common Ancestor of a Binary Tree
    | Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        else if (root.val == p.val || root.val == q.val) return root;
        else {
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
            if (leftNode == null && rightNode == null) {
                return null;
            }
            else if (leftNode != null && rightNode != null) {
                return root;
            }
            else if (rightNode != null) {
                return rightNode;
            }
            else {
                return leftNode;
            }
        }
    }
}
