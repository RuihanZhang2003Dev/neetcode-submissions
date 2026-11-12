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
    int count = 0;  // starts at 1 since root to root itself count
    public int goodNodes(TreeNode root) {
        /*
        idea: pass the current max in the iteration, if the current node is larger than current max,
        then count current node and update max
        */
        count(root, -101);
        return count;
    }

    // binary tree not BST, check all nodes
    private void count(TreeNode root, int max) {
        if (root == null) return ;    
        if (root.val >= max) {
            count++;
            max = root.val;
        }
        count(root.left, max);
        count(root.right, max);
    }
}
