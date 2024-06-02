package LeetCode.Tree;

/*
    ----------------------------------------------------------------
    | Problem: Construct Binary Tree from Preorder and Inorder Traversal
    | Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    | Status: Accepted Solution
    ----------------------------------------------------------------
*/

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0];
        int rootIndex = -1;

        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        if (rootIndex == -1) {
            return null;
        }

        int[] leftInorderSubTree = new int[rootIndex];
        int[] rightInorderSubTree = new int[length - rootIndex - 1];
        int[] leftPreorderSubTree = new int[rootIndex];
        int[] rightPreorderSubTree = new int[length - rootIndex - 1];

        int lengthLeftSubTree = leftInorderSubTree.length;

        for (int i = 0; i < rootIndex; i++) {
            leftInorderSubTree[i] = inorder[i];
        }

        for (int i = 0; i < length - rootIndex - 1; i++) {
            rightInorderSubTree[i] = inorder[rootIndex + i + 1];
        }

        for (int i = 1; i <= lengthLeftSubTree; i++) {
            leftPreorderSubTree[i - 1] = preorder[i];
        }

        for (int i = lengthLeftSubTree + 1; i < length; i++) {
            rightPreorderSubTree[i - lengthLeftSubTree - 1] = preorder[i];
        }

        TreeNode leftSubTree = buildTree(leftPreorderSubTree, leftInorderSubTree);
        TreeNode rightSubTree = buildTree(rightPreorderSubTree, rightInorderSubTree);

        return new TreeNode(rootValue, leftSubTree, rightSubTree);
    }
}
