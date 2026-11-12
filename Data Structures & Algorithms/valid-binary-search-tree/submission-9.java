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
    public boolean isValidBST(TreeNode root) {
        // idea: only checking child is not the correct approach, we should have left and right subtree
        // checks, they are different as they act differently in checks with upper and lower bound
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // private helper to check left and right;
    private boolean isValid(TreeNode root, int lower, int upper) {
        // check if current root works or not
        if (root == null) return true;

        // if not null, check with current root value and update
        int val = root.val;
        // if works, proceed to check left and right
        if (val > lower && val < upper) {
            return isValid(root.left, lower, val) && isValid(root.right, val, upper);
        }
        else return false;
    }

}
