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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        idea: find root with preorder and then build left with what is left side of root in inorder and 
        build right side with what is right side of inorder
        */
        // use a hashmap for ino
        Map<Integer, Integer> inorder_index = new HashMap<>();
        for (int i = 0; i< inorder.length; i++) {
            inorder_index.put(inorder[i], i);
        }
        return build(preorder, inorder_index, 0, inorder.length -1);
    }

    public TreeNode build(int[] pre, Map<Integer, Integer> in, int in_start, int in_end) {
        /*
        idea: build the root, then build left and right subtree recursively
        */
        if (in_start > in_end || pre_ind >= pre.length) return null;
        int rootVal = pre[pre_ind];
        TreeNode root = new TreeNode(rootVal);
        int root_ind = in.get(rootVal); // find the where the root is in the inorder
        pre_ind++;  // if we actually made a node out of this, then we advance in preorder
        root.left = build(pre, in, in_start, root_ind -1);
        root.right = build(pre, in, root_ind +1, in_end);
    
        return root;
    }
}
