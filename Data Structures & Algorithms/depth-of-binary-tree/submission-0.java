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
    public int maxDepth(TreeNode root) {
        int maxDep = 0;
        if (root != null) {
            return Math.max(maxD(root.left, maxDep +1), maxD(root.right, maxDep+1));
        }

        return maxDep;
    }

    private int maxD(TreeNode node, int curDepth) {
        if (node == null) return curDepth;
        return Math.max(maxD(node.left, curDepth+1), maxD(node.right, curDepth +1));  
    } 
}
