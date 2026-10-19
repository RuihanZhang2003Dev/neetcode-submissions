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
    // 2 global var
    int pre_ind = 0;
    HashMap<Integer, Integer> inorderPos = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1. populate hashmap
        for (int i= 0; i< inorder.length; i++) {
            inorderPos.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length -1);
    }

    // 2. helper function
    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) return null;
        // 3. get the root value
        int root_val = preorder[pre_ind++];
        // 4. create node
        TreeNode root = new TreeNode(root_val);
        // 5. find its position in inorder array
        int mid = inorderPos.get(root_val);
        // 6. create left subtree then right subtree
        root.left = dfs(preorder, l, mid-1);
        root.right = dfs(preorder, mid+1, r);
        return root;
    }
}








