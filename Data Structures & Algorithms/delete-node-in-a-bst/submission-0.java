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
        // find the key, if we find the node, pick the smallest number out of the right subtree (since
        // in the right subtree, all numbers on the right subtree is larger than key but smaller than
        // the root of the right subtree

        if (root == null) return null;
        // find the node
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

    // private helper to find the smallest and largest
    private int findSmallest(TreeNode root){
        TreeNode cur = root;
        while (cur.left != null) cur = cur.left;
        int res = cur.val;
        return res;    
    }
}



