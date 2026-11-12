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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        idea: given that we are operating on BST, that means to find the lca, we can modify the upper
        bound and the lower bound. if we choose the left child of the root, that means the root has
        become the upper bound, since no matter how you go right after, the right child will always be
        smaller than the root according to BST properties.
        */
        int upper = Math.max(p.val, q.val);
        int lower = Math.min(p.val, q.val);
        // if lowerbound larger than root now, that means root is too small, go right and check again
        if (lower > root.val) return lowestCommonAncestor(root.right, p, q);
        // if upperbound smaller than root, that means root too large, to left
        else if (upper < root.val) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}




