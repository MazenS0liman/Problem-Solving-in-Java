package LeetCode.Tree;

import java.util.Stack;

/*
    ----------------------------------------------------------------
    | Problem: Construct Binary Tree from Inorder and Postorder Traversal
    | Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        for (int j : postorder) {
            stack.push(j);
        }

        return helper(0, postorder.length - 1, inorder, stack);
    }

    public TreeNode helper(int left, int right, int[] inorder, Stack<Integer> postorder) {
        if (postorder.isEmpty() || right < left) return null;

        TreeNode root = new TreeNode(postorder.peek());
        int rootIndex = -1;

        for (int i = left; i <= right; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                postorder.pop();
            }
        }

        if (rootIndex == -1) {
            return null;
        }

        root.right = helper(rootIndex + 1, right, inorder, postorder);
        root.left = helper(left, rootIndex - 1, inorder, postorder);
        return root;
    }
}
