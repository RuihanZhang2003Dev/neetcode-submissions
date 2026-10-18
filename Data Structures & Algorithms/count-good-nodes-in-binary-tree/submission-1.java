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
    public int goodNodes(TreeNode root) {
        /*
        idea: perform pre order traversal, pass down the current max, if the node has
        a value that is larger than the current max, update current max and increase
        the good node count, go until there is no more nodes
        */
        
        int max = root.val;
        return 1+ getGoodNodes(root.left, max) + getGoodNodes(root.right, max);
    }
    private int getGoodNodes(TreeNode node, int max) {
        if (node == null) return 0;
        if (node.val >= max) {
            return 1 + getGoodNodes(node.left, node.val) + 
            getGoodNodes(node.right,node.val);
        }
        return getGoodNodes(node.left, max) + getGoodNodes(node.right, max);
    }
}












