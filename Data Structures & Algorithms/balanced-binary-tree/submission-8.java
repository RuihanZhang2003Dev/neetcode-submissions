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
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        int diff = leftH - rightH;
        if (diff == 1 || diff == -1 || diff == 0) {
            return (isBalanced(root.left) && isBalanced(root.right));
        }
        return false;
    }
    

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1+ Math.max(getHeight(node.left), getHeight(node.right));
    }
}
