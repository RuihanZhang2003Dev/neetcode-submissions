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
    Map<TreeNode, Integer> maxProfs = new HashMap<>();
    public int rob(TreeNode root) {
        /*
        idea: usually with house robber we would have 2 choices: rob this, advance 2 steps, or not
        rob this, and advance 1. if i rob the current one, I can rob all houses 2 lvls away from me
        as long as i dont rob the node between me, if i dont rob it, the max profit, would be the 
        the sum of maxprofit from left and right, since from now on, you can rob all children nodes
        as you already did your cooldown even if there is one
        */ 
        if (root == null) return 0;
        if (maxProfs.containsKey(root)) return maxProfs.get(root);
        int robCur = root.val;
        if (root.left != null) robCur += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) robCur += rob(root.right.left) + rob(root.right.right);
        int notRob = rob(root.left) + rob(root.right);
        maxProfs.put(root, Math.max(robCur, notRob));
        return maxProfs.get(root);
    }

}






