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
    int pre_ind = 0;    // every node gets a different pre_ind for different nodes
    Map<Integer, Integer> in = new HashMap<>(); 
    // to find the position of current root in inorder traversal and determine the 
    // range of its subtree

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        idea: use preorder to get the value of the root we are building, and use 
        inorder to see if current root has left and right sub tree
        */
        for (int i = 0;i< inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length -1);
    }
    private TreeNode build(int[] pre, int in_start, int in_end) {
        if (in_start > in_end) return null;
        int rootVal = pre[pre_ind];
        TreeNode root = new TreeNode(rootVal);
        int root_pos = in.get(rootVal);
        pre_ind++;
        root.left = build(pre, in_start, root_pos -1);
        root.right = build(pre, root_pos +1, in_end);
        return root;
    }
}

