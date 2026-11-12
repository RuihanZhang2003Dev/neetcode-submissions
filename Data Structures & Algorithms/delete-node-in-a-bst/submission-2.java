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
    public TreeNode deleteNode(TreeNode root, int key) {
        /*
        idea: remove the node if we found it, when we delete the node, if only one of the child is there
        then we push up only one of the child, if both are there, we take the smallest of the right sub
        tree since that would be a number < all right sub tree and > all left subtree. and we will
        loop back to delete it
        */

        if (root == null) return null;
        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = findSmallest(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    // private helper to find root
    private int findSmallest(TreeNode root) {
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.val;
    }
}
