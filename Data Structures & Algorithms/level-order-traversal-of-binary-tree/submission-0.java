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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        idea: use bfs with a queue to add the latest child node and pop the parent node
        */
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> tmpAns = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i< size; i++) {
                TreeNode n= q.remove();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
                tmpAns.add(n.val);   
            }
            result.add(tmpAns);
        }
        return result;
        
    }


}
