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

class Solution {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        /*
        idea: since max depth iterate through all nodes and calculate the left and right maxdepth
        then we can check if at some point, the current subtree is unbalanced
        */
        maxDepth(root);
        return isBalanced;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) isBalanced = false;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
}
