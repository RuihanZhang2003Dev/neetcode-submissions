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
    int pre_ind = 0;
    HashMap<Integer, Integer> indices = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        idea: since in preorder, the first element is always the root of the tree
        and in inorder, all elements in the left of the root will be the left sub tree
        and all elements in the right of the root will the right sub tree. We use a 
        hashmap for indices in inorder to make the access O(1) so that we do not need
        to access the element of the inorder array by parsing through it, then we will
        construct and the left sub tree first, and then the right sub tree.
        pre order = root-> left-> right
        inorder = left-> root-> right
        */

        // Populate the hashmap with its indices.
        for (int i = 0; i< inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length -1);
    }


    // helper to build the tree
    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l> r) return null;
        int root_val = preorder[pre_ind++]; // use the index for root rn 
        //and increment after
        TreeNode root = new TreeNode(root_val); // make the node
        int mid = indices.get(root_val);    // find where its value is in the inorder
        root.left = dfs(preorder, l, mid -1);   // then create left tree by taking 
        // the left part of the inorder and do the same for the right tree
        root.right = dfs(preorder, mid+ 1, r);
        return root;
    }
}










