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
    List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        // idea: postorder is about visiting left and right children before visiting root
        res = new ArrayList<>();
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return ;
        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }
}