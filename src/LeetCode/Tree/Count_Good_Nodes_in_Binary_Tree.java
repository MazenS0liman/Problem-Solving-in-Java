package LeetCode.Tree;

/*
    ----------------------------------------------------------------
    | Problem: Count Good Nodes in Binary Tree
    | Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Count_Good_Nodes_in_Binary_Tree {

    public int goodNodes(TreeNode root) {
        return getGoodNodes(root, root.val);
    }

    public static int getGoodNodes(TreeNode root, int maxValue) {
        if (root == null) return 0;
        maxValue = Math.max(root.val, maxValue);
        return (root.val >= maxValue ? 1 : 0) + getGoodNodes(root.left, maxValue) + getGoodNodes(root.right, maxValue);
    }


}
