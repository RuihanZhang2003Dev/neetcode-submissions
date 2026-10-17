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
        idea: this is a BST, so we will perform comparison between root, p and q, 
        check if the root is in between p and q, then we will see if left and right
        apply to the same condition too, meanwhile, we have to make sure that those 
        root can reach the node. if they do, then move to them. otherwise no need.
        */

        // To assume that p < q
        if (p.val> q.val) return lowestCommonAncestor(root, q, p);

        // if root is not in between them, go left or right
        if (root.val < p.val) {
            // if root smaller than p, then take right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (root.val > q.val) {
            // if root is too large, go left
            return lowestCommonAncestor(root.left, p, q);
        }

        // if the value of root is in between p and q, then we check if the root
        // can reach p and q.
        // the current root will be a valid root since it can always reach p and q
        // it is the highest common anscestor, now we are in the right subtree;

        return root;
    }

}
