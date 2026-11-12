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
    public int rob(TreeNode root) {
        /*
        idea: 2 options: rob or skip current house, if we rob current house, we have to skip the 
        next one, which means the maximum profit of robbing current house would be the value of 
        this house + sum of maximum profit of children nodes if we do not rob them. If we do not
        rob current house, that means we can choose between robbing children nodes or skipping 
        children nodes, so the maximum profit of skipping would be the sum of maximum profit made
        by children nodes
        */
        int[] options = maxProf(root);
        return Math.max(options[0], options[1]);
    }

    private int[] maxProf(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = maxProf(root.left);
        int[] right = maxProf(root.right);
        int rob = root.val + left[1] + right[1];
        // if we skip, we get to choose the best option that makes the most profit
        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, skip};
    }
}