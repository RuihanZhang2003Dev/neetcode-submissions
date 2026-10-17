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
    Boolean isEqual = false;
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /*
        idea: check if the current root is equal, if they are not equal, move onto
        the sub node. if they are equal, compare the tree with subRoot.
        */
        
        if (root == null) return false;
        if (root.val == subRoot.val) {
            // check if equal, left and right must be equal
            isEqual = (compare(root.left, subRoot.left) &&
            compare(root.right, subRoot.right));
        }
        // if we did not find in that one, move on
        if (!isEqual) {
            isEqual = (isSubtree(root.left, subRoot) || 
            isSubtree(root.right, subRoot));
        }
        return isEqual;
        
    }

    // helper for node
    private boolean compare(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) return true;
        if (node == null || subNode == null) return false;
        if (node.val == subNode.val) {
            return (compare(node.left, subNode.left) &&
             compare(node.right, subNode.right));
        }
        return false;
    }
    
}
