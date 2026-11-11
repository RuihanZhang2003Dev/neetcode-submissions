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
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // idea: inorder will go as left as possible, then visit root, then go right
        traverse(root, res);
        return res;
    }
    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}