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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // idea: check what to do when: one of p and q is null, or both are null, or what if 
        // their value matches? what if they dont?
        return compare(p, q);
    }

    private boolean compare(TreeNode p, TreeNode q) {
        if ((p != null && q == null) || (p == null && q != null)) return false;
        else if (p == null && q == null) return true;
        // if the val are equal we move onto sub tree
        else if (p.val == q.val) return compare(p.left, q.left) && compare(p.right, q.right);
        else return false;
    }
}
