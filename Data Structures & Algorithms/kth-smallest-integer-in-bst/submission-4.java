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
    int count = 0;
    int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        /*
        idea: we can use in-order traversal, and keep track of the nth smallest number,
        and if n = k, then return nth smallest number
        */ 
        inOrder(root, k);
        return answer;
    }
    
    // helper
    private void inOrder(TreeNode node, int target) {
        if (count > target) return;
        // visit far left
        if (node.left != null) inOrder(node.left, target);
        // when cannot no more, visit root
        count++;
        if (count == target) {
            answer = node.val;
            return;
        }
        // then visit right
        if (node.right != null) inOrder(node.right, target);
    }
}












