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
    int best = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        /*
        idea: the longest distance is the max on largest depth on left child + largest
        depth on the right child.
        */
        if (root == null) return 0;
        maxDept(root);
        return best;
    }

    private int maxDept(TreeNode node) {
        if (node == null) return 0;
        int left = maxDept(node.left);
        int right = maxDept(node.right);
        best = Math.max(best, left + right);
        return 1+ Math.max(left, right);
    }
}
