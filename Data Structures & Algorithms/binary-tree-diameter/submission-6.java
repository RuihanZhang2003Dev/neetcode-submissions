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
    public int diameterOfBinaryTree(TreeNode root) {
        /*
        idea: the longest distance is the max on largest depth on left child + largest
        depth on the right child.
        */
        if (root == null) return 0;
        return Math.max((maxDept(root.left) + maxDept(root.right)), 
        Math.max(diameterOfBinaryTree(root.left),
        diameterOfBinaryTree(root.right)));
    }

    private int maxDept(TreeNode node) {
        if (node == null) return 0;
        return 1+ Math.max(maxDept(node.left), maxDept(node.right));
    }
}
