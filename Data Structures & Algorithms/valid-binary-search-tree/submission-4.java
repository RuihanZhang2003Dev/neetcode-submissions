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
    boolean left = false;
    boolean right = false;
    public boolean isValidBST(TreeNode root) {
        /*
        idea: recursion to check if the left node < cur node and right node
        > cur node. not only that, we need to keep track of the boundaries of left and
        right
        */
        
        return (validate(root.left, -1000000001, root.val) && 
        validate(root.right, root.val, 1000000001));

    }


    // helper to validate 
    private boolean validate(TreeNode node, int minimum, int maximum){
        if (node == null) return true;
        
        // check if current node complies, then move on to the left and right child
        if (node.val > minimum && node.val < maximum) {
            // for left child, update right boundary, for right child, update left 
            // boundary
            return (validate(node.left, minimum, node.val) &&
            validate(node.right, node.val, maximum));
        }

        return false;
        
    }

}






