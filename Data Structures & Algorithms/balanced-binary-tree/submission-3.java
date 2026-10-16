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
    public boolean isBalanced(TreeNode root) {
        /*
        idea: check left height and right height.
        */
        if (root == null) return true;
        return (compare(root) && compare(root.left) && compare(root.right));
    }
    
    private boolean compare(TreeNode node) {
        if (node == null) return true;
        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);
        int diff = leftH - rightH;
        return (diff == 1 || diff == -1 || diff == 0);
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1+ Math.max(getHeight(node.left), getHeight(node.right));
    }
}
