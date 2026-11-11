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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /*
        idea: this is the same question as the same binary tree, except now we have to compare every
        root that matches the subroot and check if they are binary tree. If they got matching root,
        compare subtree, other wise move onto the child nodes of root, and look for subtree
        */
        if (root == null) return false;
        else if (compare(root, subRoot)) return true;
        else return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // helper for compare
    private boolean compare(TreeNode root, TreeNode subRoot) {
        if ((root == null && subRoot != null) || (root != null && subRoot == null)) return false;
        else if (root == null && subRoot == null) return true;
        else if (root.val == subRoot.val) {
            return compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
        }
        else return false;
    }
}
